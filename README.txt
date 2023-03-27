map.txt format:

ID~visited~roomName~roomDescription~connections

<ID> - String - Room identification number
<visited> - String - true/false value for room visit status
<roomName> - String - Name of the room
<roomDescription> - String - Description of the currently occupied room
<connections> - String - String of numbers that signify that direction of other enterable rooms
(in the order North, East, South, West)

Default Map:
 ___ ___
|   |   |
|_1_|_2_|
|   |   |
|_3_|_4_|
|   |   |
|_5_|_6_|

Default map.txt File:
1~false~room 1~You wake up in the middle of an empty white room with doors on each side~0,2,3,0
2~false~room 2~Another white room~0,0,4,1
3~false~room 3~A white room~1,4,5,0
4~false~room 4~Yet again, another white room~2,0,6,3
5~false~room 5~How many white rooms are there?~3,6,0,0
6~false~room 6~Yup, another white room~4,0,0,5

Chair Map:
 ___
|   |
|_1_|___ ___
|   |   |   |
|_2_|_3_|_4_|
|   |   |   |
|_5_|   |_6_|

Chair map.txt format:
1~false~room 1~You wake up in the middle of an empty white room with doors on each side~0,0,2,0
2~false~room 2~Another white room~1,3,5,0
3~false~room 3~A white room~0,4,0,2
4~false~room 4~Yet again, another white room~0,0,6,3
5~false~room 5~How many white rooms are there?~2,0,0,0
6~false~room 6~Yup, another white room~4,0,0,0

[SIMPLY COPY AND REPLACE THE TEXT IN map.txt WITH THE CHAIR MAP.TXT FORMAT]

------------------------------------------------------------------------------------------------------------------------
item.txt format:

itemName~itemDescription~itemRoomLocation

<itemName> - String - Name of the item
<itemDescription> - String - Description of the item
<itemRoomLocation> - String - Signifies the room in which the item resides

Default item.txt File:
jewel~this is a red jewel~1
sword~this is a rusty sword~3
creature~this is a fuzzy boi~5

Alternate item.txt File:
mirror~This is a small handheld mirror. You do not see your reflection.~2
fidget-spinner~A black fidget spinner. I guess this will keep me occupied.~4
smartphone~A smartphone with a cracked screen. The battery is out.~6

[SIMPLY COPY AND REPLACE THE TEXT IN item.txt WITH THE alternate item.txt FORMAT]
------------------------------------------------------------------------------------------------------------------------
puzzles.txt format:

puzzleLocation~puzzleQuestion~puzzleAnswer~correctMessage~wrongMessage~attempts~solved

<puzzleLocation> - String - signifies the room in which the puzzle resides
<puzzleQuestion> - String - Description of the puzzle question
<puzzleAnswer> - String - the answer for the puzzle question
<correctMessage> - String - Message that is displayed when the user answer the question correctly
<wrongMessage> - String - Message that is displayed when the user answers the question wrong
<attempts> - String - Signifies how many times the user can attempt to solve the puzzle
<solved> - String - true/false value for if the puzzle has been solved or not

Default puzzle.txt File:
2~what planet do you live on?~earth~You solved the puzzle correctly!~the answer you provided is wrong~3~false
6~what color is the sky?~blue~You solved the puzzle correctly!~the answer you provided is wrong~5~false

