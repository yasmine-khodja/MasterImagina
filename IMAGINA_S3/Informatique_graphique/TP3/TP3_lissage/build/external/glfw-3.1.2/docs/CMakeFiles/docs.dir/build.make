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

# Utility rule file for docs.

# Include the progress variables for this target.
include external/glfw-3.1.2/docs/CMakeFiles/docs.dir/progress.make

external/glfw-3.1.2/docs/CMakeFiles/docs:
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --blue --bold --progress-dir=/home/e20180009306/Bureau/MasterImagina/IMAGINA_S3/Informatique_graphique/TP3/TP3_lissage/build/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Generating HTML documentation"
	cd /home/e20180009306/Bureau/MasterImagina/IMAGINA_S3/Informatique_graphique/TP3/TP3_lissage/build/external/glfw-3.1.2/docs && /usr/bin/doxygen

docs: external/glfw-3.1.2/docs/CMakeFiles/docs
docs: external/glfw-3.1.2/docs/CMakeFiles/docs.dir/build.make

.PHONY : docs

# Rule to build all files generated by this target.
external/glfw-3.1.2/docs/CMakeFiles/docs.dir/build: docs

.PHONY : external/glfw-3.1.2/docs/CMakeFiles/docs.dir/build

external/glfw-3.1.2/docs/CMakeFiles/docs.dir/clean:
	cd /home/e20180009306/Bureau/MasterImagina/IMAGINA_S3/Informatique_graphique/TP3/TP3_lissage/build/external/glfw-3.1.2/docs && $(CMAKE_COMMAND) -P CMakeFiles/docs.dir/cmake_clean.cmake
.PHONY : external/glfw-3.1.2/docs/CMakeFiles/docs.dir/clean

external/glfw-3.1.2/docs/CMakeFiles/docs.dir/depend:
	cd /home/e20180009306/Bureau/MasterImagina/IMAGINA_S3/Informatique_graphique/TP3/TP3_lissage/build && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /home/e20180009306/Bureau/MasterImagina/IMAGINA_S3/Informatique_graphique/TP3/TP3_lissage /home/e20180009306/Bureau/MasterImagina/IMAGINA_S3/Informatique_graphique/TP3/TP3_lissage/external/glfw-3.1.2/docs /home/e20180009306/Bureau/MasterImagina/IMAGINA_S3/Informatique_graphique/TP3/TP3_lissage/build /home/e20180009306/Bureau/MasterImagina/IMAGINA_S3/Informatique_graphique/TP3/TP3_lissage/build/external/glfw-3.1.2/docs /home/e20180009306/Bureau/MasterImagina/IMAGINA_S3/Informatique_graphique/TP3/TP3_lissage/build/external/glfw-3.1.2/docs/CMakeFiles/docs.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : external/glfw-3.1.2/docs/CMakeFiles/docs.dir/depend

