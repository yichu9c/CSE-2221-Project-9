Project: String Reassembly
Objectives
Familiarity with using Set objects and methods.
Familiarity with using JUnit to test methods.
Exposure to the kinds of computations involved in computational biology.
The Problem
One of the marvels of modern science, made possible by the use of sophisticated computer algorithms, is the famous Human Genome Project. Some background and related resources are available in the slides on genome reassembly from fragments.

The idea of reassembling a long sequence from many overlapping fragments of the whole is not new. It is the basis for an early 20th-century technique called dendrochronology, where it has enabled the creation of year-by-year records of tree-ring growth patterns in some geographical regions over intervals as long as several thousand years. These sequences have been used to pinpoint the dates of construction for ancient structures with wooden members such as the cliff dwellings at Mesa Verde National Park in the southwestern U.S. However, the ability to reassemble very long patterns such as the sequence of some 3 billion nucleotides in a strand of human DNA — from millions of fragments — is new. This "scaling up" of the basic sequence-reassembly concept was crucial to the success of the Human Genome Project. How can this sort of thing be done? That is the question you will explore a bit in this project.

Setup
Create a new Eclipse project by copying ProjectTemplate or a previous project you have created, naming the new project StringReassemblyFromFragments.
Open the src folder of this project and then open (default package). As a starting point you can use any of the Java files. Rename the class StringReassembly and delete the other files from the project.
Follow the link to StringReassembly.java, select all the code on that page and copy it to the clipboard; then open the StringReassembly.java file in Eclipse and paste the code to replace the file contents. Save the file.
In the test folder of this project create a new JUnit test fixture as practiced in a recent lab. Name it StringReassemblyTest.
Method
In following the instructions below, you may choose to write code for StringReassemblyTest.java first, or to write code for StringReassembly.java first, or to alternate between them method-by-method. Different strokes for different folks; do what works best for you! If you're not sure what works best for you, try writing the code for StringReassemblyTest.java first if this approach (called test-driven development) is new to you.

Edit StringReassemblyTest.java to create test cases for all methods you are implementing in StringReassembly.java. Use the test fixture to test your code in StringReassembly.java, debugging it as necessary.
Edit StringReassembly.java to implement the methods not yet implemented, following the instructions and advice in the comments. As a guide, be sure to examine the code for the other methods whose bodies are provided already, as well as the main program. This folder holds some text files containing fragments derived from rather small original documents on which to try your solution. We recommend you download these files and place them in the data folder of your Eclipse project. For files with over 1000 lines, expect to wait a minute or more to reassemble the strings. Also, recall that the greedy solution does not always result in an optimal result, declaration-50-8.txt and gettysburg-30-4.txt will not be fully reassembled by our implementation (for added challenge, try to determine why it occurs for these files but not the others).

Note that each line separator in the original documents that were "shredded" to create the above fragment files has first been replaced by '~'. Separate lines of the fragment files contain separate fragments of the respective original documents.

Select your Eclipse project StringReassembly (not just some of the files, but the whole project), create a zip archive of it, and submit the zip archive to the Carmen dropbox for this project, as described in Submitting a Project.
Additional Activities
Here are some possible additional activities related to this project. Any extra work is strictly optional, for your own benefit, and will not directly affect your grade.

Create a separate class with a main program that can be used to generate a substantial file of fragments, one per line, from an original source text of moderate length in a file specified by the user. You should be able to leverage the Random component family from the OSU CSE Components. Select many randomly positioned fragments, each of random length over some range. It seems string reassembly works best when the typical fragment is reasonably long (at least several dozen characters) and there are enough fragments in total to "cover" the original source text several times over (say, 10 times).
