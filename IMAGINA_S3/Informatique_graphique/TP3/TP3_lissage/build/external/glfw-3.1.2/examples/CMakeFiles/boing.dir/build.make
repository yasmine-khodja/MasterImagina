# CMAKE generated file: DO NOT EDIT!
# Generated by "Unix Makefiles" Generator, CMake Version 3.10

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:


#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:


# Remove some rules from gmake that .SUFFIXES does not remove.
SUFFIXES =

.SUFFIXES: .hpux_make_needs_suffix_list


# Suppress display of executed commands.
$(VERBOSE).SILENT:


# A target that is always out of date.
cmake_force:

.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

# The shell in which to execute make rules.
SHELL = /bin/sh

# The CMake executable.
CMAKE_COMMAND = /usr/bin/cmake

# The command to remove a file.
RM = /usr/bin/cmake -E remove -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = /home/e20180009306/Bureau/MasterImagina/IMAGINA_S3/Informatique_graphique/TP3/TP3_lissage

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /home/e20180009306/Bureau/MasterImagina/IMAGINA_S3/Informatique_graphique/TP3/TP3_lissage/build

# Include any dependencies generated for this target.
include external/glfw-3.1.2/examples/CMakeFiles/boing.dir/depend.make

# Include the progress variables for this target.
include external/glfw-3.1.2/examples/CMakeFiles/boing.dir/progress.make

# Include the compile flags for this target's objects.
include external/glfw-3.1.2/examples/CMakeFiles/boing.dir/flags.make

external/glfw-3.1.2/examples/CMakeFiles/boing.dir/boing.c.o: external/glfw-3.1.2/examples/CMakeFiles/boing.dir/flags.make
external/glfw-3.1.2/examples/CMakeFiles/boing.dir/boing.c.o: ../external/glfw-3.1.2/examples/boing.c
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/e20180009306/Bureau/MasterImagina/IMAGINA_S3/Informatique_graphique/TP3/TP3_lissage/build/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building C object external/glfw-3.1.2/examples/CMakeFiles/boing.dir/boing.c.o"
	cd /home/e20180009306/Bureau/MasterImagina/IMAGINA_S3/Informatique_graphique/TP3/TP3_lissage/build/external/glfw-3.1.2/examples && /usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -o CMakeFiles/boing.dir/boing.c.o   -c /home/e20180009306/Bureau/MasterImagina/IMAGINA_S3/Informatique_graphique/TP3/TP3_lissage/external/glfw-3.1.2/examples/boing.c

external/glfw-3.1.2/examples/CMakeFiles/boing.dir/boing.c.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing C source to CMakeFiles/boing.dir/boing.c.i"
	cd /home/e20180009306/Bureau/MasterImagina/IMAGINA_S3/Informatique_graphique/TP3/TP3_lissage/build/external/glfw-3.1.2/examples && /usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -E /home/e20180009306/Bureau/MasterImagina/IMAGINA_S3/Informatique_graphique/TP3/TP3_lissage/external/glfw-3.1.2/examples/boing.c > CMakeFiles/boing.dir/boing.c.i

external/glfw-3.1.2/examples/CMakeFiles/boing.dir/boing.c.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling C source to assembly CMakeFiles/boing.dir/boing.c.s"
	cd /home/e20180009306/Bureau/MasterImagina/IMAGINA_S3/Informatique_graphique/TP3/TP3_lissage/build/external/glfw-3.1.2/examples && /usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -S /home/e20180009306/Bureau/MasterImagina/IMAGINA_S3/Informatique_graphique/TP3/TP3_lissage/external/glfw-3.1.2/examples/boing.c -o CMakeFiles/boing.dir/boing.c.s

external/glfw-3.1.2/examples/CMakeFiles/boing.dir/boing.c.o.requires:

.PHONY : external/glfw-3.1.2/examples/CMakeFiles/boing.dir/boing.c.o.requires

external/glfw-3.1.2/examples/CMakeFiles/boing.dir/boing.c.o.provides: external/glfw-3.1.2/examples/CMakeFiles/boing.dir/boing.c.o.requires
	$(MAKE) -f external/glfw-3.1.2/examples/CMakeFiles/boing.dir/build.make external/glfw-3.1.2/examples/CMakeFiles/boing.dir/boing.c.o.provides.build
.PHONY : external/glfw-3.1.2/examples/CMakeFiles/boing.dir/boing.c.o.provides

external/glfw-3.1.2/examples/CMakeFiles/boing.dir/boing.c.o.provides.build: external/glfw-3.1.2/examples/CMakeFiles/boing.dir/boing.c.o


# Object files for target boing
boing_OBJECTS = \
"CMakeFiles/boing.dir/boing.c.o"

# External object files for target boing
boing_EXTERNAL_OBJECTS =

external/glfw-3.1.2/examples/boing: external/glfw-3.1.2/examples/CMakeFiles/boing.dir/boing.c.o
external/glfw-3.1.2/examples/boing: external/glfw-3.1.2/examples/CMakeFiles/boing.dir/build.make
external/glfw-3.1.2/examples/boing: external/glfw-3.1.2/src/libglfw3.a
external/glfw-3.1.2/examples/boing: /usr/lib/x86_64-linux-gnu/librt.so
external/glfw-3.1.2/examples/boing: /usr/lib/x86_64-linux-gnu/libm.so
external/glfw-3.1.2/examples/boing: /usr/lib/x86_64-linux-gnu/libX11.so
external/glfw-3.1.2/examples/boing: /usr/lib/x86_64-linux-gnu/libXrandr.so
external/glfw-3.1.2/examples/boing: /usr/lib/x86_64-linux-gnu/libXinerama.so
external/glfw-3.1.2/examples/boing: /usr/lib/x86_64-linux-gnu/libXi.so
external/glfw-3.1.2/examples/boing: /usr/lib/x86_64-linux-gnu/libXxf86vm.so
external/glfw-3.1.2/examples/boing: /usr/lib/x86_64-linux-gnu/libXcursor.so
external/glfw-3.1.2/examples/boing: /usr/lib/x86_64-linux-gnu/libGL.so
external/glfw-3.1.2/examples/boing: external/glfw-3.1.2/examples/CMakeFiles/boing.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=/home/e20180009306/Bureau/MasterImagina/IMAGINA_S3/Informatique_graphique/TP3/TP3_lissage/build/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking C executable boing"
	cd /home/e20180009306/Bureau/MasterImagina/IMAGINA_S3/Informatique_graphique/TP3/TP3_lissage/build/external/glfw-3.1.2/examples && $(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/boing.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
external/glfw-3.1.2/examples/CMakeFiles/boing.dir/build: external/glfw-3.1.2/examples/boing

.PHONY : external/glfw-3.1.2/examples/CMakeFiles/boing.dir/build

external/glfw-3.1.2/examples/CMakeFiles/boing.dir/requires: external/glfw-3.1.2/examples/CMakeFiles/boing.dir/boing.c.o.requires

.PHONY : external/glfw-3.1.2/examples/CMakeFiles/boing.dir/requires

external/glfw-3.1.2/examples/CMakeFiles/boing.dir/clean:
	cd /home/e20180009306/Bureau/MasterImagina/IMAGINA_S3/Informatique_graphique/TP3/TP3_lissage/build/external/glfw-3.1.2/examples && $(CMAKE_COMMAND) -P CMakeFiles/boing.dir/cmake_clean.cmake
.PHONY : external/glfw-3.1.2/examples/CMakeFiles/boing.dir/clean

external/glfw-3.1.2/examples/CMakeFiles/boing.dir/depend:
	cd /home/e20180009306/Bureau/MasterImagina/IMAGINA_S3/Informatique_graphique/TP3/TP3_lissage/build && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /home/e20180009306/Bureau/MasterImagina/IMAGINA_S3/Informatique_graphique/TP3/TP3_lissage /home/e20180009306/Bureau/MasterImagina/IMAGINA_S3/Informatique_graphique/TP3/TP3_lissage/external/glfw-3.1.2/examples /home/e20180009306/Bureau/MasterImagina/IMAGINA_S3/Informatique_graphique/TP3/TP3_lissage/build /home/e20180009306/Bureau/MasterImagina/IMAGINA_S3/Informatique_graphique/TP3/TP3_lissage/build/external/glfw-3.1.2/examples /home/e20180009306/Bureau/MasterImagina/IMAGINA_S3/Informatique_graphique/TP3/TP3_lissage/build/external/glfw-3.1.2/examples/CMakeFiles/boing.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : external/glfw-3.1.2/examples/CMakeFiles/boing.dir/depend

