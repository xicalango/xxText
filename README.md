xxText
======

A library and GUI for rapidly applying scripts on a text.

Quickstart
==========

Start the xxTextGUI project.

Insert the text you want on the left textarea.

Use the right textarea to write a script using the following objects:

* _in: a BufferedReader on the document on the left
* _out: a PrintWriter to a newly created document
* _text: the complete text incl. '\n'
* _lines: a java array holding the document split on '\n'

Click on Use script and the script is applied to the active document on the left textarea creating a new document.
