# makkefile begins

VPATH = ./src
CLASS_DIR= class
TARGET=gui.jar
# define a variable for compiler flags (JFLAGS) (-d points to class' dir)
# define a variable for the compiler (JC)
# define a variable for the Java Virtual Machine (JVM)
# define a variable for a parameter. When you run make, you could use:
# make run FILE="Algo.csv" para sobre escribir el valor de FILE.

JFLAGS = -g -d $(CLASS_DIR)
JC = javac
JVM= java
FILE=

#
# Clear any default targets for building .class files from .java files; we
# will provide our own target entry to do this in this makefile.
# make has a set of default targets for different suffixes (like .c.o)
# Currently, clearing the default for .java.class is not necessary since
# make does not have a definition for this target, but later versions of
# make may, so it doesn't hurt to make sure that we clear any default
# definitions for these
#

.SUFFIX=.java .class

#
# CLASSES is a macro consisting of N words (one for each java source file)
# When a single line is too long, use \<return> to split lines that then will be
# considered as a single line. For example:
# NAME = Camilo \
         Juan
# is understood as
# NAME = Camilo        Juan

# CLASSES = \
#         Experiment.java \
#         Block.java \
#         Spring.java \
#         PhysicsElement.java \
#         Simulator.java

CLASSES = \
	gui.java \


#
# MAIN is a variable with the name of the class AND file containing the main
# method
#

MAIN = gui

#
# the default make target entry
# for this example it is the target jar

default: jar


# Next line is a target dependency line
# This target entry uses Suffix Replacement within a macro AND prefix addition:
# $(addprefix PREFIX, $(macroname:string1=string2))
# In the words in the macro named 'macroname' replace 'string1' with 'string2'
# Below we are replacing the suffix .java of all words in the macro CLASSES
# with the .class suffix AND adding directory class
#

jar $(TARGET): $(addprefix $(CLASS_DIR)/, $(CLASSES:.java=.class))
	jar -v --create --file $(TARGET) --main-class $(MAIN)  -C $(CLASS_DIR)  $(CLASSES:.java=.class)

#
# Next lines contain target class for each .java source file in SRC_DIR
#

$(CLASS_DIR)/%.class : %.java
	$(JC) $(JFLAGS) $<

# Next two lines contain a target for running the program
# Remember the tab in the second line.
# $(JMV) and $(TARGET) are replaced by their values

run: $(TARGET)
	$(JVM) -jar $(TARGET)

# this line is to remove all unneeded files from
# the directory when we are finished executing(saves space)
# and "cleans up" the directory of unneeded .class files BUT JAR file remains
# RM is a predefined macro in make (RM = rm -f)
#

clean:
	$(RM)  $(CLASS_DIR)/*.class

gitadd: $(addprefix $(SRC_DIR), $(CLASSES)) makefile
	git add $?
