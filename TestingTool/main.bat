del commandoutput.txt
start /W /b both.bat
type txt1.txt >> commandoutput.txt
echo FILE2 >> commandoutput.txt
type  txt2.txt >> commandoutput.txt
del txt1.txt txt2.txt
notepad commandoutput.txt
exit