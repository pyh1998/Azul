# Assignment Two Feedback


## Group  tue12p
u7111608 Jiawen Wang
u7211790 Yuhui Pang
u6616888 Qinling Zhong

## Tutor Comment

Congratulations on a solid and easy-to-play game! I like the background music and sound effects - they certainly make the game more engaging to play! The four-player game seems to work well.

Overall the code quality is excellent - clear, well-documented, and correct - with only a few minor issues.

The design is sensible and makes good use of object orientation.

Minor issues:

It is usually better to use local variables e.g. for `sharedState` and `playerStates` in `Azul.isStateValid:337-448` than to use static (or instance) fields e.g. `Azul.isMoveValid:390-391`. Unless the fields are *required* to preserve state from one method call to the next, it's far better to have this information as local variables, as that allows us to reason about the behaviour of each method call in isolation (we don't need to think about what methods were called on this object before or afterwards).

It would have been nice to see some unit tests that didn't use the string representation of the game. Given you developed a nice object-oriented API (the classes and methods in the `playerState`, `sharedState`, and `Tile` packages), your unit tests could have tested the implementation of this API.

Where a precondition of the code is not fulfilled, for example at `Tile.java:46` where a `Tile` is being constructed with any character other than `a`-`f`, this should be indicated via an exception. As it stands, the `Tile` could be created with a null `TILE_COLOR`, which will only be discovered later when trying to call a method on the `Tile`. It would be better to crash immediately.

`Discard.getTotalNumOfTiles`: copying an array just  

Only use ALL_CAPS for the names of constants. Constants are `static final` fields, and are distinguished from *immutable fields* which are only `final`. Also, ALL_CAPS should not be used in method names.

The Javadoc comments for the GUI mostly describe things that are obvious and trivial (e.g. "the constructor of SharedGroup"). There's no need to document anything that is obvious in the code. Instead, describe what the non-trivial behaviour e.g. "draw the bag as the five colours of tile with the number of each tile currently in the bag".

Always place Javadoc comments immediately before the component of the class to which they refer. For example, in `Floor.java` there should be three separate Javadoc comments:
````
    /** The maximum number of tiles that the Floor can hold */
    public final static int MAX_LENGTH = 7;
    /** The total number of tiles in the Floor */
    private int number;
    /** The tiles in the Floor */
    private Tile[] tiles;
````

## Mark

**  12.0/13.0**

## Miscellaneous marks

| Level | Requirement | Result |
|:--:|---|:--:|
|    | All files correct                   | .5 / .5  |
|    | Authorship clear for all classes    | .25/ .25 |
|    | Program runs from JAR               | .5 / .5  |
|    | Appropriate use of Git              | .5 / .5  |
| P  | Appropriate use of OO features      | 1.0/1.0  |
| CR | Program well designed               |  .5/ .5  |
| CR | Comments clear and sufficient       | .25/ .25 |
| CR | Coding style good                   | .25/ .25 |
| CR | Appropriate use of JUnit tests      | .25/ .25 |
| D  | Design and code of very high quality|  .5/ .5  |
| D  | Works well and easy to run          |  .5/. 5  |
| HD | Demonstrates interesting extensions |  .5/ .5  |
| HD | Game is exceptional                 |    /1.0  |

**Total for miscellaneous marks:**  5.5/6.5

## Game marks (manual)

| Level | Requirement | Result |
|:-:|---|:-:|
|CR|Pieces snap into place (12)      | .25/.25 |
|CR|Only valid placement allowed (12)| .25/.25 |
|D |Basic computer opponent (14)     | .5 /.5  |
|HD|Advanced computer opponent (15)  | .5 /.5  |
|HD|Interesting variant (16)         | .25/.25 |

**Total for manual marks:** 1.75/1.75

## Test results

```
Test Name   Tests Passed  Weighting      Score
-----              -----      -----      -----
task2                3/3      0.125      0.125
task3                2/2      0.125      0.125
task5                3/3       0.25       0.25
task6                5/5        0.5        0.5
task7                1/1       0.25       0.25
task8                5/5        0.5        0.5
task9                8/8       0.75       0.75
task10             11/11        1.0        1.0
task11               4/4        0.5        0.5
task13               2/2       0.75       0.75
-----              -----     Total:  4.75/4.75
```
## Originality statements

#### Originality statement F
# IMPORTANT: It is very important that you correctly complete this originality
# statement.
#
# This is your statement of your submitted work being your own.
# Incorrectly filling out this statement could lead to charges
# of academic misconduct.
# 
# For information on how to fill this out correctly, see
# https://cs.anu.edu.au/courses/comp1110/help/faq/09-originality/
#

declaration: >-
  Stage F represents the culmination of the entire assignment.  We declare that
  everything we have submitted for for all stages of this assignment was
  entirely our own work, with the following exceptions:

# Use this to list names of people who you collaborated with, and a
# comment about what you collaborated on.
#
# Add as many "name+comment" entries as necessary
# (or remove it altogether if you haven't collaborated with anyone)
#collaboration:
#  - name:
#    comment: >-

# Use this to list any code that you used that you did not write,
# aside from code provided by the lecturer.  Provide a comment
# explaining your use and the URL to that code and the licence for
# that code
#
# Add as many "url+licence+comment" entries as necessary
# (or remove it altogether if you haven't used any external code)
code:
  - comment: refered to last year's ass1 dinosaurs to add sound effect and bgm
    url: N/A
    licence: All right reserved

  - comment: refered to Almas Baimagambetov's YouTube video "JavaFX Custom Game Menu - Thief" to add the game menu
    url: https://www.youtube.com/watch?v=aOcow70vqb4&ab_channel=AlmasBaimagambetov
    licence: All right reserved

# Use this to list any assets (artwork, sound, etc) that you used.
# Provide a comment explaining your use of that asset and the URL
# and license for the asset
#
# Add as many "url+licence+comment" entries as necessary
# (or remove it altogether if you haven't used any external assets)
assets:
  - comment: Menu background music, Yugen - Emotional Ethnic Music by Keys of Moon
      url: https://soundcloud.com/keysofmoon
      licence: Attribution 4.0 International (CC BY 4.0)

  - comment: Game background music, {Old Bossa} by Twin Musicom
    url: http://www.twinmusicom.org/
    licence: Attribution 4.0 International (CC BY 4.0)

  - comment: click sound 1
    url: https://sc.chinaz.com/yinxiao/180904492042.htm
    licence: CopyRight 2002-2020

  - comment: click sound 3,
    url: https://sc.chinaz.com/yinxiao/171122209170.htm
    licence: CopyRight 2002-2020

  - comment: game menu background, image published by W. Eric Martin in website boardgamegeek
      url: https://boardgamegeek.com/image/3718275/azul
      licence: Attribution 3.0 Unported (CC BY 3.0)

  - comment: game background, image published by illustratelife in www.vecteezy.com
      url: https://www.vecteezy.com/vector-art/273835-white-background
      licence: Attribution 3.0 Unported (CC BY 3.0)

  - comment: game rule, images in the rulebook
      url: https://www.boardgamecapital.com/game_rules/azul.pdf
      licence: Attribution 3.0 Unported (CC BY 3.0)

# Sign *your* name and uids here. (Remove entries if you have fewer
# than three members.)
signatures:
  - name: Yuhui Pang
    uid: u7211790
  - name: Qinling Zhong
    uid: u6616888
  - name: Jiawen Wang
    uid: u7111608

#### Originality statement E
# IMPORTANT: It is very important that you correctly complete this originality
# statement.
#
# This is your statement of your submitted work being your own.
# Incorrectly filling out this statement could lead to charges
# of academic misconduct.
# 
# For information on how to fill this out correctly, see
# https://cs.anu.edu.au/courses/comp1110/help/faq/09-originality/
#

declaration: >-
  We declare that everything we have submitted for Stage E of this assignment
  and all stages before it is entirely our own work, with the following
  exceptions:

# Use this to list names of people who you collaborated with, and a
# comment about what you collaborated on.
#
# Add as many "name+comment" entries as necessary
# (or remove it altogether if you haven't collaborated with anyone)
#collaboration:
#  - name:
#    comment: >-

# Use this to list any code that you used that you did not write,
# aside from code provided by the lecturer.  Provide a comment
# explaining your use and the URL to that code and the licence for
# that code
#
# Add as many "url+licence+comment" entries as necessary
# (or remove it altogether if you haven't used any external code)
#code:
#  - comment:
#    url:
#    licence:

# Use this to list any assets (artwork, sound, etc) that you used.
# Provide a comment explaining your use of that asset and the URL
# and license for the asset
#
# Add as many "url+licence+comment" entries as necessary
# (or remove it altogether if you haven't used any external assets)
#assets:
#  - comment:
#    url:
#    licence:


# Sign *your* name and uids here. (Remove entries if you have fewer
# than three members.)
signatures:
  - name: Yuhui Pang
    uid: u7211790
  - name: Qinling Zhong
    uid: u6616888
  - name: Jiawen Wang
    uid: u7111608

#### Originality statements D
# IMPORTANT: It is very important that you correctly complete this originality
# statement.
#
# This is your statement of your submitted work being your own.
# Incorrectly filling out this statement could lead to charges
# of academic misconduct.
# 
# For information on how to fill this out correctly, see
# https://cs.anu.edu.au/courses/comp1110/help/faq/09-originality/
#

declaration: >-
  I declare that everything I have submitted for stage D of this assignment
  and all stages before it is entirely my own work, with the following
  exceptions:

# sign *your* name and uid here
name: Qinling Zhong
uid: u6616888
# IMPORTANT: It is very important that you correctly complete this originality
# statement.
#
# This is your statement of your submitted work being your own.
# Incorrectly filling out this statement could lead to charges
# of academic misconduct.
# 
# For information on how to fill this out correctly, see
# https://cs.anu.edu.au/courses/comp1110/help/faq/09-originality/
#

declaration: >-
  I declare that everything I have submitted for stage D of this assignment
  and all stages before it is entirely my own work, with the following
  exceptions:

# sign *your* name and uid here
name: Jiawen Wang
uid: u7111608
# IMPORTANT: It is very important that you correctly complete this originality
# statement.
#
# This is your statement of your submitted work being your own.
# Incorrectly filling out this statement could lead to charges
# of academic misconduct.
# 
# For information on how to fill this out correctly, see
# https://cs.anu.edu.au/courses/comp1110/help/faq/09-originality/
#

declaration: >-
  I declare that everything I have submitted for stage D of this assignment
  and all stages before it is entirely my own work, with the following
  exceptions:




# sign *your* name and uid here
name: Yuhui Pang
uid: u7211790

#### Originality statement C
# IMPORTANT: It is very important that you correctly complete this originality
# statement.
#
# This is your statement of your submitted work being your own.
# Incorrectly filling out this statement could lead to charges
# of academic misconduct.
# 
# For information on how to fill this out correctly, see
# https://cs.anu.edu.au/courses/comp1110/help/faq/09-originality/
#

declaration: >-
  We declare that everything we have submitted for Stage C of this assignment
  and all stages before it is entirely our own work, with the following
  exceptions:

# Use this to list names of people who you collaborated with, and a
# comment about what you collaborated on.
#
# Add as many "name+comment" entries as necessary
# (or remove it altogether if you haven't collaborated with anyone)
#collaboration:
#  - name:
#    comment: >-

# Use this to list any code that you used that you did not write,
# aside from code provided by the lecturer.  Provide a comment
# explaining your use and the URL to that code and the licence for
# that code
#
# Add as many "url+licence+comment" entries as necessary
# (or remove it altogether if you haven't used any external code)
#code:
#  - comment:
#    url:
#    licence:

# Use this to list any assets (artwork, sound, etc) that you used.
# Provide a comment explaining your use of that asset and the URL
# and license for the asset
#
# Add as many "url+licence+comment" entries as necessary
# (or remove it altogether if you haven't used any external assets)
#assets:
#  - comment:
#    url:
#    licence:


# Sign *your* name and uids here. (Remove entries if you have fewer
# than three members.)
signatures:
  - name: Yuhui Pang
    uid: u7211790
  - name: Qinling Zhong
    uid: u6616888
  - name: Jiawen Wang
    uid: u7111608

#### Originality statement B
# IMPORTANT: It is very important that you correctly complete this originality
# statement.
#
# This is your statement of your submitted work being your own.
# Incorrectly filling out this statement could lead to charges
# of academic misconduct.
# 
# For information on how to fill this out correctly, see
# https://cs.anu.edu.au/courses/comp1110/help/faq/09-originality/
#

declaration: >-
  We declare that everything we have submitted for Stage B of this assignment
  and all stages before it is entirely our own work, with the following
  exceptions:

# Use this to list names of people who you collaborated with, and a
# comment about what you collaborated on.
#
# Add as many "name+comment" entries as necessary
# (or remove it altogether if you haven't collaborated with anyone)
#collaboration:
#  - name:
#    comment: >-

# Use this to list any code that you used that you did not write,
# aside from code provided by the lecturer.  Provide a comment
# explaining your use and the URL to that code and the licence for
# that code
#
# Add as many "url+licence+comment" entries as necessary
# (or remove it altogether if you haven't used any external code)
#code:
#  - comment:
#    url:
#    licence:

# Use this to list any assets (artwork, sound, etc) that you used.
# Provide a comment explaining your use of that asset and the URL
# and license for the asset
#
# Add as many "url+licence+comment" entries as necessary
# (or remove it altogether if you haven't used any external assets)
#assets:
#  - comment:
#    url:
#    licence:


# Sign *your* name and uids here. (Remove entries if you have fewer
# than three members.)
signatures:
  - name: Yuhui Pang
    uid: u7211790
  - name: Qinling Zhong
    uid: u6616888
  - name: Jiawen Wang
    uid: u7111608

## Git Contributions
#### Commit count via git log
```
      4 Bob <u1234567@anu.edu.au>
      1 Cindy <u71116708@anu.edu.au>
      1 Cindy <u7111698@anu.edu.au>
    104 Jiawen Wang <u7111608@anu.edu.au>
     19 Josh Milthorpe <josh.milthorpe@anu.edu.au>
     21 Qinling Zhong <u6616888@anu.edu.au>
     80 Yuhui Pang <u7211790@anu.edu.au>

```
#### Line count via git blame
```
      1 Bob
   1417 Jiawen
   1818 Josh
     14 Qinling
   3453 Yuhui
```
## Git Log
```
commit 567c6168e8442d6fd3431bf51753a2bd3668d713
Author: Yuhui Pang <u7211790@anu.edu.au>
Date:   Fri May 21 01:09:03 2021 +0800

    change some layouts

commit de28f7b0b742d427107a6a3f5d406bf2ad87672c
Merge: 55a0056 f4c6973
Author: Yuhui Pang <u7211790@anu.edu.au>
Date:   Thu May 20 23:47:31 2021 +0800

    Merge branch 'master' of https://gitlab.cecs.anu.edu.au/comp1110/comp1110-ass2

commit 55a005686c04f278e25a35d1f2ef6410b613abeb
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Thu May 20 23:39:26 2021 +0800

    Add hint for controlling music

commit 3f273c6ee1e2e93a98986e0363716217c0cc9fe6
Merge: fa4fc4d b3bbc10
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Thu May 20 23:20:34 2021 +0800

    Merge remote-tracking branch 'origin/master'
    
    # Conflicts:
    #       game.jar

commit fa4fc4d7f8b597da5dc14f3fb4cbf05d7c1a1a84
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Thu May 20 23:19:37 2021 +0800

    fix back button

commit b3bbc106a16b9337cb491654ef310610b36ea859
Author: Qinling Zhong <u6616888@anu.edu.au>
Date:   Thu May 20 22:57:51 2021 +0800

    F-best-u6616888

commit ac86c4a086462484e8a7a7e7a4ca2f2233c7a594
Author: Qinling Zhong <u6616888@anu.edu.au>
Date:   Thu May 20 22:53:11 2021 +0800

    F-best-u6616888

commit f3f115ed82630d3f351b8826423c607b726eddd2
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Thu May 20 22:47:00 2021 +0800

    comments

commit b666cc2b91642d04ea9f1ef97f5a0824cff635a4
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Thu May 20 22:39:22 2021 +0800

    contribution

commit 7a2d3fb089f3bfc57fc43ab24c50a8534e5f7a93
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Thu May 20 22:36:27 2021 +0800

    update comments and best code file

commit aea4035967f44eb44e52ec8134c8437c3f74be4b
Merge: 21f3835 550dacb
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Thu May 20 22:27:38 2021 +0800

    Merge remote-tracking branch 'origin/master'
    
    # Conflicts:
    #       game.jar

commit 21f3835e438885c21dd7aa2bd19d3c93dfc5930e
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Thu May 20 22:26:51 2021 +0800

    add comments and authorship in Game.java

commit 550dacb4d6f7f28b1dbdb7ae99259ec062b371dc
Author: Yuhui Pang <u7211790@anu.edu.au>
Date:   Thu May 20 22:17:31 2021 +0800

    update viewer to the old version

commit e51dac3bea4fc34b08be5c7349e91a9c76e032ba
Author: Yuhui Pang <u7211790@anu.edu.au>
Date:   Thu May 20 22:03:04 2021 +0800

    update comments

commit f45312c9b61b1b77101d1b0f0c3daf6e7115172b
Merge: dc326c8 e10c616
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Thu May 20 21:34:46 2021 +0800

    Merge remote-tracking branch 'origin/master'

commit e10c6163432758b0a79e9e9088dbe77a4fddcba7
Author: Yuhui Pang <u7211790@anu.edu.au>
Date:   Thu May 20 21:21:37 2021 +0800

    Update features

commit dc326c8e0a81258b4089cd4e12a40008f153082b
Merge: 71439d7 398779f
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Thu May 20 21:18:46 2021 +0800

    Merge branch 'master' of https://gitlab.cecs.anu.edu.au/u7111608/comp1110-ass2-tue12p

commit 398779f1bec4bec7716d37515482b9d1f84e8c23
Author: Yuhui Pang <u7211790@anu.edu.au>
Date:   Thu May 20 20:31:28 2021 +0800

    add my F-best

commit 71439d718bd0969e651afb5c2ff19bce84828096
Merge: b20fc47 eb2b34e
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Thu May 20 20:19:28 2021 +0800

    Merge remote-tracking branch 'origin/master'
    
    # Conflicts:
    #       game.jar

commit b20fc47520336135ff4b67a29905430a5e2403bc
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Thu May 20 20:18:48 2021 +0800

    delete backCover

commit eb2b34ea25f229d7e15557c1116219dc33d72200
Author: Yuhui Pang <u7211790@anu.edu.au>
Date:   Thu May 20 20:11:27 2021 +0800

    retry with task9

commit 73989d01bc9243731453519ac52056248bf9b2ee
Author: Yuhui Pang <u7211790@anu.edu.au>
Date:   Thu May 20 16:31:54 2021 +0800

    Do some changes with task9

commit f2f6d132f0e409734bfd330da7f7d633edaa5900
Author: Yuhui Pang <u7211790@anu.edu.au>
Date:   Thu May 20 16:28:39 2021 +0800

    Do some changes with task9

commit 09ceed390daded85f0b66d0062ed2e36eff815a6
Author: Yuhui Pang <u7211790@anu.edu.au>
Date:   Thu May 20 08:48:32 2021 +0800

    Update Game Menu

commit ee72cde28764b245fb65bf900505b60b6e92d015
Author: Yuhui Pang <u7211790@anu.edu.au>
Date:   Thu May 20 00:46:45 2021 +0800

    little change

commit c0fedddc17dbbc4b2b30521ecbeba4f21647423f
Author: Yuhui Pang <u7211790@anu.edu.au>
Date:   Thu May 20 00:39:58 2021 +0800

    111

commit d31c1bc9f12e582c9d050c1e91c03d2729ca7d45
Merge: 6e534c1 e5da60e
Author: Yuhui Pang <u7211790@anu.edu.au>
Date:   Thu May 20 00:34:19 2021 +0800

    Merge remote-tracking branch 'origin/master'
    
    # Conflicts:
    #       game.jar
    #       src/comp1110/ass2/gui/Game.java

commit e5da60ed358e5c87b445974fe53a48d2a705f28f
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Thu May 20 00:28:59 2021 +0800

    updated Yuhui's changes of Variant Mosaic

commit 6e534c1ee630706f561cdae968b4b9f5e562b517
Merge: 563609c a1fc567
Author: Yuhui Pang <u7211790@anu.edu.au>
Date:   Thu May 20 00:27:37 2021 +0800

    Merge remote-tracking branch 'origin/master'
    
    # Conflicts:
    #       game.jar
    #       src/comp1110/ass2/gui/Game.java

commit 1a67b2175bf8636049a7cc15fcbeec2880c61902
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Thu May 20 00:18:46 2021 +0800

    Solve merge problem

commit 563609cf94a4a4d1ee02683ec330edb6fad8109c
Author: Yuhui Pang <u7211790@anu.edu.au>
Date:   Thu May 20 00:17:56 2021 +0800

    Make radioButton larger

commit a1fc56795acd6493b18b0238f8bbfc04d7ad8c9d
Merge: 553a54b c6514d7
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Thu May 20 00:14:58 2021 +0800

    Added rules to the menu

commit 553a54bedcea402cc0a1256960ab07a0d94ae77f
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Wed May 19 23:49:20 2021 +0800

    Added rules to the menu

commit c6514d760556c5aff0231c12d2b71c9cdd4e8974
Author: Yuhui Pang <u7211790@anu.edu.au>
Date:   Wed May 19 23:25:36 2021 +0800

    add Variant Mosaic

commit 409e70d7a5b7207509d19691e64f1f409caaa4d8
Author: Yuhui Pang <u7211790@anu.edu.au>
Date:   Wed May 19 18:03:34 2021 +0800

    Add playing with computer
    add a background

commit f15523e952ee8a043a01a239b5f73acd33c4e06d
Author: Yuhui Pang <u7211790@anu.edu.au>
Date:   Wed May 19 00:13:38 2021 +0800

    Fix with Task9

commit 9e1bbcaaef37eebd96c664b58a08f3613d8bb5b1
Merge: c884702 69f1f8f
Author: Yuhui Pang <u7211790@anu.edu.au>
Date:   Wed May 19 00:08:57 2021 +0800

    Merge remote-tracking branch 'origin/master'
    
    # Conflicts:
    #       game.jar

commit c884702a1ec2b54b66caed6a7c46abd5bddd40f3
Author: Yuhui Pang <u7211790@anu.edu.au>
Date:   Wed May 19 00:08:20 2021 +0800

    Attempt to add rule

commit 69f1f8fbba4e9bfbb06f1f5b754472379cf8b69e
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Tue May 18 23:30:17 2021 +0800

    improve menu position

commit 21658da73f67b104649aa404c9fe5cf19c5154eb
Author: Yuhui Pang <u7211790@anu.edu.au>
Date:   Tue May 18 22:09:50 2021 +0800

    Fix some bugs

commit c7849b943d3953745ce8b3ec1bf8b5ca3336c500
Author: Yuhui Pang <u7211790@anu.edu.au>
Date:   Tue May 18 21:52:10 2021 +0800

    3 or 4 players can play

commit 8c4973b581fb2e1a609cbbaec7415c43a19b26ae
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Mon May 17 11:24:33 2021 +0800

    added best files for each member

commit f4c69737505bde8407971f6869bbd114dda828d2
Author: Josh Milthorpe <josh.milthorpe@anu.edu.au>
Date:   Mon May 17 12:02:41 2021 +1000

    Fix IsMoveValidTest.testStorageToFloor() to obey row order for tiling move

commit 6145217552e117c805ba2f1b394fb3accc2e5e22
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Sun May 16 22:39:35 2021 +0800

    add makeCompletion and checkCompletion

commit 1025e2b0c4eb348d716bebe5047a73b2f5f81c1a
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Sun May 16 20:46:24 2021 +0800

    Added game menu to choose number of players

commit cf4eef991cb3bf8e135d2e34f8e7dbb5af64035f
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Sun May 16 16:11:06 2021 +0800

    Added sounds, made f not draggable

commit 8837ca64e4484bddc6c599c46b5dc2e184c7fc4b
Author: Qinling Zhong <u6616888@anu.edu.au>
Date:   Sun May 16 11:19:09 2021 +0800

    Task 9

commit 81837d64233b5e67150b28d7daf4465aec2da641
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Sat May 15 16:24:31 2021 +0800

    fix task 15, deleted unused statements

commit 059c71a0bda6b34b839977fc70ce9e943b05515d
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Sat May 15 16:21:15 2021 +0800

    done task 15, draftingMove with the highest heuristic score, and tillingMove with the highest game score

commit 73c32dd999b82593698c7e66981caf60bac22ba1
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Sat May 15 15:43:38 2021 +0800

    modify generateAction to return the move with the highest score.

commit 1987df3d8fe13e6688a677cf23092fd7acb4dbae
Author: Yuhui Pang <u7211790@anu.edu.au>
Date:   Thu May 13 20:40:46 2021 +0800

    task12

commit eb75bb02dece936aedca0183a69fd06be00c8ce7
Author: Josh Milthorpe <josh.milthorpe@anu.edu.au>
Date:   Thu May 13 10:41:02 2021 +1000

    remove move string from game state in ApplyMoveTest.testFloorFull() (thanks Yuhui Pang)

commit 07a558e20e2a9bdd224050a6741d820a7f3d68cb
Author: Qinling Zhong <u6616888@anu.edu.au>
Date:   Thu May 13 01:32:13 2021 +0800

    part of task 9

commit 3c98a3b96896b7125491cd28c43786964f05f114
Author: Yuhui Pang <u7211790@anu.edu.au>
Date:   Mon May 10 23:26:02 2021 +0800

    add PlayerGroup and SharedGroup

commit c466a2e9ac2a7037e0fa665370dc74ec963ef6cc
Author: Yuhui Pang <u7211790@anu.edu.au>
Date:   Mon May 10 23:24:06 2021 +0800

    add PlayerGroup and SharedGroup

commit f9dfe2f1dc589505349fedb16174df48cc4ad081
Author: Yuhui Pang <u7211790@anu.edu.au>
Date:   Mon May 10 22:52:19 2021 +0800

    add playerNum to constructor of Factory and SharedState

commit 48eee22d7a566e6b4ae6c0f1f7d6eaa0a03a8643
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Fri May 7 21:25:04 2021 +0800

    Added method getAllValidMoves to Azul

commit c2f8d3ccbe11a48a104cf2e7f8d7ff46e97560ec
Author: Josh Milthorpe <josh.milthorpe@anu.edu.au>
Date:   Tue May 4 12:31:43 2021 +1000

    feedback for D2E

commit 69eec817415b52f915ad904adbe7fa15f0e65a60
Author: Qinling Zhong <u6616888@anu.edu.au>
Date:   Mon May 3 01:30:06 2021 +0800

    Update E-Review

commit b89702d984782af78b0e1a9917cd2ed2847e5332
Author: Qinling Zhong <u6616888@anu.edu.au>
Date:   Mon May 3 01:28:26 2021 +0800

    Update E-Review

commit 9fba7a35429a55c5f2de9c7c32cb4e4476afca68
Author: Yuhui Pang <u7211790@anu.edu.au>
Date:   Sun May 2 23:25:15 2021 +0800

    Update the comments

commit 0d3528510905d59ee0855c6dece0d764305f4524
Author: Yuhui Pang <u7211790@anu.edu.au>
Date:   Sun May 2 22:25:12 2021 +0800

    Add E-review-u7211790.md

commit b6cdcf324d614a0eae04d4872f71808e7a24850f
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Sat May 1 01:26:03 2021 +0800

    done task 13

commit a8a67ff60e9868da4ac9fee09ab58071c64e8676
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Fri Apr 30 21:12:40 2021 +0800

    done tilling move for task 13, added a few authorship

commit 174deab8c934cf389675c30935d303246ebd1a52
Author: Yuhui Pang <u7211790@anu.edu.au>
Date:   Fri Apr 30 00:32:14 2021 +0800

    Done with task11

commit b5b4f9e89224c82a70f24d410f1984540032ba89
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Thu Apr 29 11:49:39 2021 +0800

    updated tasks.md

commit 0a03f39edfe9d128e7ffa4cee0e6b0804dabb17f
Merge: 660ab42 3e1789b
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Thu Apr 29 11:43:20 2021 +0800

    Merge remote-tracking branch 'origin/master'

commit 660ab427a1cc8d2bc03b1111bc0372e1ad9fdd11
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Thu Apr 29 11:42:53 2021 +0800

    code review

commit 3e1789bb9419e134beb3ce37125c40ce61e6c6ea
Author: Yuhui Pang <u7211790@anu.edu.au>
Date:   Thu Apr 29 11:26:24 2021 +0800

    task11 drafting move

commit 0c2d48ac62c3d3b258a63b21bbb6bf10734075c6
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Thu Apr 29 10:28:42 2021 +0800

    updated originality and contribution

commit 488197e9b9a79cdb162dcdad80cbc60a03d6d1fd
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Thu Apr 29 10:24:37 2021 +0800

    updated game jar

commit 0f5d8b7ce78e3d10f3e2317f25a2cd9d68d40f9a
Merge: 3d18cf7 d9dece0
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Thu Apr 29 10:03:24 2021 +0800

    Merge remote-tracking branch 'origin/master'

commit 3d18cf7ddd56c1d99849928aaca5ebba605fc61e
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Thu Apr 29 10:02:56 2021 +0800

    Added game jar

commit d9dece0889cf7b10f5664379d8898a31e3e1060e
Author: Yuhui Pang <u7211790@anu.edu.au>
Date:   Thu Apr 29 09:46:24 2021 +0800

    Fix with task2

commit 0632c1ac6b631704bda9bfedbd41db957e38ab0d
Merge: 6dd3905 05eb1ab
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Thu Apr 29 09:30:33 2021 +0800

    Merge branch 'master' of https://gitlab.cecs.anu.edu.au/comp1110/comp1110-ass2

commit 6dd390544b42eaaf59c3cba1aa54c32da63386ca
Author: Yuhui Pang <u7211790@anu.edu.au>
Date:   Thu Apr 29 09:05:23 2021 +0800

    incomplete with task11(to be continued)

commit 05eb1ab94b736f69345e4dfd86d7975af0e6a932
Author: Josh Milthorpe <josh.milthorpe@anu.edu.au>
Date:   Wed Apr 28 21:01:22 2021 +1000

    Fixed invalid states in isMoveValidTest (Thanks  John (Min Jae) Kim)
    Fixed string mutation in testStorageNotFull (thanks Qin-Yu Zhao)

commit 8ff28c82fbdd9a02b7e44d68ee3f75d9202399e2
Author: Yuhui Pang <u7211790@anu.edu.au>
Date:   Tue Apr 27 22:33:03 2021 +0800

    incomplete with task11(to be continued)

commit 0ee50074b4c660ea0f6c1ccd72001c9901bfb06f
Author: Qinling Zhong <u6616888@anu.edu.au>
Date:   Mon Apr 26 02:52:16 2021 +0800

    Update D-originality

commit 6f09c87fd498b9734616703ce8098ea8d174a480
Author: Qinling Zhong <u6616888@anu.edu.au>
Date:   Mon Apr 26 01:50:30 2021 +0800

    Update D-originality

commit 2df77e9e85f405b2772f8d2184a3511fac64d3f9
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Sun Apr 25 20:34:57 2021 +0800

    rename rowIsContained()

commit ca42a31ae014b518db526f8ee98a8c382e0968ca
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Sun Apr 25 20:28:19 2021 +0800

    Added comments for isValidPlacement

commit b2f971d7d82827d458bba7bf2504b1f3d958c628
Merge: 9170fc2 cb46cb7
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Sun Apr 25 19:21:11 2021 +0800

    Merge remote-tracking branch 'origin/master'

commit 9170fc252c52f2f3cd5d897529c65a82488c5713
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Sun Apr 25 19:20:58 2021 +0800

    Added tests for the new code in PlayerStateTest

commit cb46cb77c5df433f8cee2c63946a831412100a72
Author: Yuhui Pang <u7211790@anu.edu.au>
Date:   Sun Apr 25 16:36:09 2021 +0800

    Update the new code and D-originality

commit 01fc510169daa6decfc5cc7a74d0dc1607a3f62e
Author: Yuhui Pang <u7211790@anu.edu.au>
Date:   Sun Apr 25 16:25:11 2021 +0800

    Update Floor and Discard

commit 798bffcaf466f178c01b40a90c31941907956629
Author: Yuhui Pang <u7211790@anu.edu.au>
Date:   Sun Apr 25 15:58:49 2021 +0800

    add notes with getFirstPlayerTileFromFloor

commit 916a44f9a070575843d8c7cf010bd5f90688ec68
Author: Yuhui Pang <u7211790@anu.edu.au>
Date:   Sun Apr 25 15:50:04 2021 +0800

    Use getAllPlayerState in task 7 and 8 and update myTest

commit f84c97c157dcde49d6316dbca4c0f0d3d858c050
Author: Yuhui Pang <u7211790@anu.edu.au>
Date:   Sun Apr 25 15:48:24 2021 +0800

    Some changes with PlayerState

commit 49ddeacf255eca5a28d24521c27cc71a2b27978e
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Sun Apr 25 11:42:13 2021 +0800

    Signed originality and filled in newcode

commit acfc9f948a1bbe948ef2ed1d23365b01b9a7b3f6
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Sun Apr 25 10:21:28 2021 +0800

    Added newcode files and contribution files for each member

commit b1d2cd4b49f843892055da6eda84315bca955432
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Sun Apr 25 10:16:07 2021 +0800

    Done task 10

commit 9de9d5641c063bb1e9858827515d781c5d3bf5c1
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Sun Apr 25 05:27:56 2021 +0800

    fixed isValidPlacement

commit d98c424b149de7a30b45b5674dcd20826399704a
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Sun Apr 25 05:23:43 2021 +0800

    methods isValidPlacement and addTileToMosaic in Mosaic

commit 22ed450c2006a49f30b3b7b0202857f4a7928705
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Sun Apr 25 05:02:12 2021 +0800

    added getAllPlayerStatesTest()

commit 88516283980b29aafe83189e88a6ef4dbd58f353
Author: Yuhui Pang <u7211790@anu.edu.au>
Date:   Sat Apr 24 23:01:27 2021 +0800

    Update Task7,8

commit b1dabb4d27f762e280d5766b1e86719095410dde
Merge: 1b8217b 5e85709
Author: Yuhui Pang <u7211790@anu.edu.au>
Date:   Sat Apr 24 22:21:36 2021 +0800

    Merge branch 'master' of https://gitlab.cecs.anu.edu.au/u7111608/comp1110-ass2-tue12p

commit 5e8570950ad0b5969830f9df249f9a8ec69ca485
Merge: d1a6a8e 3241c34
Author: Josh Milthorpe <josh.milthorpe@anu.edu.au>
Date:   Fri Apr 23 20:06:14 2021 +1000

    Merge branch 'master' of https://gitlab.cecs.anu.edu.au/u7111608/comp1110-ass2-tue12p

commit d1a6a8ed50720577fd03b6cf53b597e5416d6bd9
Author: Josh Milthorpe <josh.milthorpe@anu.edu.au>
Date:   Fri Apr 23 20:05:25 2021 +1000

    feedback for D2C

commit 5f039f3ef6e8321b11c0f8befd3e5e40bd1316ce
Author: Josh Milthorpe <josh.milthorpe@anu.edu.au>
Date:   Tue Apr 20 12:27:49 2021 +1000

    remove not-well-formed test for factory with 3 tiles; add test for non-existent tile

commit 3241c34da54d895d93e71eba3262aa83ee9d7fc5
Author: Qinling Zhong <u6616888@anu.edu.au>
Date:   Mon Apr 19 16:03:12 2021 +0800

    best-u6616888

commit 1b8217baf5b81bfa36b0e825b9cd8dce1d12e5a3
Merge: 7d9d011 7f710fc
Author: Yuhui Pang <u7211790@anu.edu.au>
Date:   Mon Apr 19 16:01:50 2021 +0800

    Merge branch 'master' of https://gitlab.cecs.anu.edu.au/u7111608/comp1110-ass2-tue12p

commit 7f710fcf64dad866f4bd93b41ea2a0c21a91a777
Author: Qinling Zhong <u6616888@anu.edu.au>
Date:   Mon Apr 19 15:58:29 2021 +0800

    best-u6616888

commit 7d9d011098193104c585352215cd4ff8aabcbb5f
Merge: 002c386 bd931ae
Author: Yuhui Pang <u7211790@anu.edu.au>
Date:   Mon Apr 19 10:28:18 2021 +0800

    Merge branch 'master' of https://gitlab.cecs.anu.edu.au/comp1110/comp1110-ass2

commit 002c3860b001fdd66f94a3a6af373e57788ce777
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Sun Apr 18 21:10:59 2021 +0800

    Updated collaboration in best file

commit af73f5782c59234578984db73a7054bf72baad63
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Sun Apr 18 21:05:44 2021 +0800

    Updated tasks.md and u7111608 best code file

commit 9e092b2527a65eea187488466ef5409e2c927407
Author: Yuhui Pang <u7211790@anu.edu.au>
Date:   Sun Apr 18 20:45:33 2021 +0800

    Update C-best-7211790.yml

commit 18afd205cb2a1db2772c61060c462fbf3ba23093
Author: Yuhui Pang <u7211790@anu.edu.au>
Date:   Sun Apr 18 20:44:08 2021 +0800

    Update C-best-7211790.yml

commit 199116fe8110dc1e889b7af816a622b13acedb60
Author: Yuhui Pang <u7211790@anu.edu.au>
Date:   Sun Apr 18 20:16:06 2021 +0800

    Add initial string in task4

commit 6a0ec41b02da2dd07590d4ca91986c89138c030f
Author: Yuhui Pang <u7211790@anu.edu.au>
Date:   Sun Apr 18 18:56:37 2021 +0800

    Some changes with Task4

commit bd931ae0fdaa8c33d509d352133eb4af4eaecf3d
Author: Josh Milthorpe <josh.milthorpe@anu.edu.au>
Date:   Sun Apr 18 20:47:58 2021 +1000

    fix invalid states in GetBonusPointsTest and NextRoundTest

commit 38c451d6fe10bb144538b556dc61f248b9242b3f
Author: Yuhui Pang <u7211790@anu.edu.au>
Date:   Sun Apr 18 18:09:34 2021 +0800

    Done with Task4

commit 35cc9e15c4fb849aae59f17da57ce15fcac6f7c6
Author: Yuhui Pang <u7211790@anu.edu.au>
Date:   Sun Apr 18 12:52:51 2021 +0800

    Update Contribution

commit e390c0899c22fda453fcf59cdf7484d1690e2f12
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Sat Apr 17 22:34:57 2021 +0800

    Add best files and fill in  contribution

commit abeee9b6a57c2511c08ac197aafc0bbcac8b773d
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Sat Apr 17 22:05:32 2021 +0800

    Change Azul back

commit e381b7959c4faeb9612762009d390fe43bf0ec8b
Merge: 23917d8 1fb3860
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Sat Apr 17 21:54:22 2021 +0800

    Merge remote-tracking branch 'origin/master'

commit 23917d8f5a93c2cdabda8c42dd8298c2106d1741
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Sat Apr 17 21:54:03 2021 +0800

    go back to the previous commit

commit 1fb38600aee013dd807ab8d5d045467ce727f3e9
Merge: 7a15f92 39a5e3d
Author: Yuhui Pang <u7211790@anu.edu.au>
Date:   Sat Apr 17 21:34:26 2021 +0800

    Merge remote-tracking branch 'origin/master'

commit 7a15f92dd1a01a5b31b164e38b7d82b801c3a267
Author: Yuhui Pang <u7211790@anu.edu.au>
Date:   Sat Apr 17 21:26:21 2021 +0800

    Some Changes with Viewer.java

commit 39a5e3d456ea27f573f16b770d94e269d4c08cac
Merge: 3c477a2 152c5ba
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Sat Apr 17 21:14:31 2021 +0800

    try to merge

commit 3c477a2463a4fc6a7e9f7e93059b56304349c3fa
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Sat Apr 17 21:09:49 2021 +0800

    Tried test 8 and passed 2 tests

commit 152c5bab737544d63ca1ac2d788fae1a9395cca9
Author: Yuhui Pang <u7211790@anu.edu.au>
Date:   Sat Apr 17 20:50:07 2021 +0800

    Delete some unusable field in Tile class

commit acf64e44d2e779a6fb7baf2e6f5aa71c6497a642
Author: Yuhui Pang <u7211790@anu.edu.au>
Date:   Sat Apr 17 20:48:46 2021 +0800

    Delete TileColor and TileLocation Class

commit c86e5d70275e9876cf6ebb2b19ff6597e34d4ada
Author: Yuhui Pang <u7211790@anu.edu.au>
Date:   Sat Apr 17 20:41:29 2021 +0800

    Done with Task8

commit eb3d6233330992db079709107e48e6d43dcdd2c7
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Sat Apr 17 19:56:44 2021 +0800

    getLostScore in class Floor

commit ebf8c79107e51d7d8e9e8430e5ff2d8444508d4b
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Sat Apr 17 19:41:35 2021 +0800

    fixed getAllPlayerStates again

commit 677e632b9837675a99357c03b480dcd0c3300495
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Sat Apr 17 19:11:14 2021 +0800

    fixed getAllPlayerStates

commit 0a4c106fb1adf8af4fe25d263988f5e625baeb19
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Sat Apr 17 18:12:34 2021 +0800

    created getAllPlayerStates, updated moveTilesToDiscard and made tile id public

commit 43fb0fc348a94d37ef40d1cb42031cd5a432c91d
Merge: 2be4099 d536153
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Fri Apr 16 12:46:49 2021 +0800

    Merge remote-tracking branch 'origin/master'

commit 2be4099fad1385d931375f7755135c08c6ded20a
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Fri Apr 16 12:46:37 2021 +0800

    Added comments in the classes of the folder playerState

commit d5361539b0739f9c9af963ff3eaf474fe1cb7de6
Author: Yuhui Pang <u7211790@anu.edu.au>
Date:   Fri Apr 16 12:32:50 2021 +0800

    update with task6

commit bfd6cda6b295b370dc719ec5fb66ae0b03250bab
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Fri Apr 16 12:15:31 2021 +0800

    Added comments in PlayerState

commit 56569c21590ee2e60fe5fd4bc750bf33f6f5ac2d
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Fri Apr 16 11:50:24 2021 +0800

    Changed package name of shareState to sharedState

commit 7f459d9eb8c372d2da8341d7965d72f730bc91f7
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Fri Apr 16 11:48:09 2021 +0800

    Deleted unuseful classes and move PlayerState and SharedState to the corresponding folders, Added comments to SharedState

commit 713d9c227fa1e31e6a5f77584b9ee82237da2876
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Fri Apr 16 11:02:22 2021 +0800

    Task 6: Combined if statements

commit e3c2a2417ed54983c893f65f486d14d695eb1b19
Author: Yuhui Pang <u7211790@anu.edu.au>
Date:   Fri Apr 16 10:39:11 2021 +0800

    update with task6

commit 06848443e58a4fc6b340ac271d087662007a2ca1
Merge: de660e2 25e06b4
Author: Yuhui Pang <u7211790@anu.edu.au>
Date:   Fri Apr 16 10:20:08 2021 +0800

    Merge branch 'master' of https://gitlab.cecs.anu.edu.au/u7111608/comp1110-ass2-tue12p

commit de660e27a9276d5a8a42b2d9cb615b944e43b715
Author: Yuhui Pang <u7211790@anu.edu.au>
Date:   Fri Apr 16 10:19:52 2021 +0800

    update with task2

commit 25e06b47b7daa99c6051c5909fa6926bcbebeef4
Merge: da0b322 5ad75a6
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Fri Apr 16 10:10:35 2021 +0800

    Merge branch 'master' of https://gitlab.cecs.anu.edu.au/comp1110/comp1110-ass2

commit bdefd82eb74b89c514c1239d14e046a5ae9f9f97
Merge: da0b322 5ad75a6
Author: Yuhui Pang <u7211790@anu.edu.au>
Date:   Fri Apr 16 10:07:49 2021 +0800

    Merge branch 'master' of https://gitlab.cecs.anu.edu.au/comp1110/comp1110-ass2

commit da0b3221cab4ed041b9016a4997b96640ac4393e
Author: Yuhui Pang <u7211790@anu.edu.au>
Date:   Fri Apr 16 10:03:18 2021 +0800

    Some attempts with TASK4

commit 8bc8e2868c8347dbe3f8b86626a1f91927bbb6f4
Author: Yuhui Pang <u7211790@anu.edu.au>
Date:   Fri Apr 16 10:02:33 2021 +0800

    update the Azul.java and Done with TASK7

commit 31048a3c8f5bc02dcdee8ec7cd7084f4135bccfa
Author: Yuhui Pang <u7211790@anu.edu.au>
Date:   Fri Apr 16 10:01:39 2021 +0800

    Add some tests!

commit 361bee326b17c9adcc416fe785b985a87bb69e64
Author: Yuhui Pang <u7211790@anu.edu.au>
Date:   Fri Apr 16 10:00:50 2021 +0800

    Change the classes in play

commit 76856d41745dfe95cc3e01889c61cbe81648a854
Author: Yuhui Pang <u7211790@anu.edu.au>
Date:   Fri Apr 16 10:00:12 2021 +0800

    Change the classes in playerState

commit 81894845987c64cb40ff843131a9947387c02e5d
Author: Yuhui Pang <u7211790@anu.edu.au>
Date:   Fri Apr 16 09:59:24 2021 +0800

    Change the classes in shareState

commit 990b03b604cb0292727dec1980d639bd2ac1fea9
Author: Yuhui Pang <u7211790@anu.edu.au>
Date:   Fri Apr 16 09:58:16 2021 +0800

    Change the classes in Tile

commit 5ad75a6f484846b35e8bf21e2962eec6a4fd3415
Author: Josh Milthorpe <josh.milthorpe@anu.edu.au>
Date:   Fri Apr 16 09:24:35 2021 +1000

    Fix non-well-formed states in NextRoundTest and GetBonusPointsTest
    
    Clarify error message in notNextRound Test factory-centre string specifically rather than entire shared state string

commit 1b065abbf5c0a6df1de56a998960a260f4f8443e
Author: Josh Milthorpe <josh.milthorpe@anu.edu.au>
Date:   Thu Apr 15 19:57:41 2021 +1000

    several improvements to tests
    
    Add test for centre tiles not in alphabetical order, thanks Xuanchen Wang
    Fix bonus scoring for nextRoundTest. Thanks  John (Min Jae) Kim and Juren Xu
    Clone test arrays to prevent test errors from state modification
    Add test to refillFactories for non-empty factories. Fix solution of refillFactories to check for tiles in the centre
    Fix nextRound to add bonusPoints at end of game
    Fix final score of Example Game Ashleigh Johannes Yesterday 10:35

commit e46d8d4f4391f97b8b193f8844fce7db54e53ab9
Author: Josh Milthorpe <josh.milthorpe@anu.edu.au>
Date:   Mon Apr 12 22:06:42 2021 +1000

    complete set of tests, including new tests for Tasks 8 and 13

commit e1c8962ee8b5433e712aef9b6ce31a50aaaad883
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Sun Apr 11 16:26:05 2021 +0800

    Updated a small change to task 5 and 6

commit dc0e6967e8be684a448e6249ae2555731b8cd5a3
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Sun Apr 11 16:23:21 2021 +0800

    Updated task 5

commit b0baf898311f2b81c90536d307e459be8aadb76e
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Sun Apr 11 16:22:20 2021 +0800

    Updated task 6

commit 1225f6113aaee3e4d9fe8fa22e94b30f101c9a36
Merge: e3f048d b2b0023
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Sun Apr 11 15:56:34 2021 +0800

    Merge branch 'master' of https://gitlab.cecs.anu.edu.au/comp1110/comp1110-ass2

commit e3f048d7872966a17e088ecacc53b8fc4f7700e9
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Sun Apr 11 15:54:54 2021 +0800

    Updated task 5

commit b2b00238ec4057e542d119cb175db0e85a2c4ec7
Author: Josh Milthorpe <josh.milthorpe@anu.edu.au>
Date:   Tue Apr 6 16:53:13 2021 +1000

    fixes to incorrect strings in README (thanks to Qin-Yu Zhao)
    
    also update Javadoc for Azul.isSharedStateWellFormed to include Turn substring

commit 5c7fce888fc541b08d91199cc8187562a47f95f4
Merge: 0f8c1bd d84e068
Author: Yuhui Pang <u7211790@anu.edu.au>
Date:   Thu Apr 1 16:54:10 2021 +0800

    Merge remote-tracking branch 'origin/master'

commit 0f8c1bda36279f502c47ceb76d9b4a931ccd0826
Author: Yuhui Pang <u7211790@anu.edu.au>
Date:   Thu Apr 1 16:53:25 2021 +0800

    Update Task3

commit d84e0681bc2ccb39e99f24f3bf05a5df29f2d9f7
Author: Qinling Zhong <u6616888@anu.edu.au>
Date:   Wed Mar 31 19:54:16 2021 +0800

    Update Task 3

commit 6646f46b70e3b4fba2da4afe1df2238ac3c43a9f
Author: Qinling Zhong <u6616888@anu.edu.au>
Date:   Wed Mar 31 19:40:49 2021 +0800

    Update Task 3

commit d91b25c1aa6a152b892d51edd38c6e57d3f09b31
Author: Qinling Zhong <u6616888@anu.edu.au>
Date:   Wed Mar 31 19:28:11 2021 +0800

    Update Task 3

commit a907536d31bb01223fe21a6f2e6a9897245bb300
Author: Qinling Zhong <u6616888@anu.edu.au>
Date:   Wed Mar 31 19:22:14 2021 +0800

    Update Task 3

commit 5bc91d84717ae9462b49962f17745ca1074d20a2
Author: Josh Milthorpe <josh.milthorpe@anu.edu.au>
Date:   Tue Mar 30 12:39:29 2021 +1100

    feedback for D2B

commit 79e3c9b60fbd8c678c82dc98df1fac480ba18ae6
Author: Yuhui Pang <u7211790@anu.edu.au>
Date:   Sun Mar 28 20:19:31 2021 +0800

    Update Drafting class

commit fd899fd12eb0ebdfe14695e9f215144fcf857b22
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Sat Mar 27 17:00:11 2021 +0800

    Updated tasks.md

commit a31c56f05bd8c82cbe3d88c30ea8f059b47a5a1b
Author: Qinling Zhong <u6616888@anu.edu.au>
Date:   Sat Mar 27 16:50:15 2021 +0800

    Update Drafting Class

commit efd970dfcea4eda007f2c394c555fcea30f8a9af
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Sat Mar 27 16:24:58 2021 +0800

    Updated MosaicTilling Drafting

commit 0de1eec1ddff72674e4ef9a5a79874cce0411fb9
Merge: 15492a9 df9f9d6
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Sat Mar 27 16:20:01 2021 +0800

    Merge remote-tracking branch 'origin/master'

commit 15492a9730e359cf1f191ae3f4c4338ad9cdb113
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Sat Mar 27 16:19:47 2021 +0800

    Updated class Drafting

commit df9f9d6544c3e5df532a9c4d8b208406138c98a4
Author: Yuhui Pang <u7211790@anu.edu.au>
Date:   Sat Mar 27 16:18:40 2021 +0800

    Update Scoring class

commit 61149890d85e3c96a33af8630d1a8d6b97f923d0
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Sat Mar 27 16:03:41 2021 +0800

    Added comments for Constructor

commit 81903e64b0f28f5b54140bf43aa9ec248fb1c825
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Sat Mar 27 16:01:42 2021 +0800

    Added another constructor for tiles in Mosaic

commit 79514d188d2ec640b772886064cb6a3aed9b1336
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Sat Mar 27 15:57:31 2021 +0800

    Added boolean on turn in class Player

commit 4cbeb7099e654336f4870b7f36be06844ae9f751
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Sat Mar 27 15:54:16 2021 +0800

    updated Storage class

commit 280b32c943372f6bd41d1bd13de345187f08c815
Merge: b73728d d51d739
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Sat Mar 27 15:48:52 2021 +0800

    Merge remote-tracking branch 'origin/master'

commit b73728df6fea7f06ab82fdccaaaa4a1594d2c6fb
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Sat Mar 27 15:48:36 2021 +0800

    updated Mosaic and Storage class

commit d51d739daa5b261ba309551190bc1a5f7a164597
Author: Yuhui Pang <u7211790@anu.edu.au>
Date:   Sat Mar 27 15:41:24 2021 +0800

    Update Bag class

commit 94e680be7fd151d34377f99121d596ef97f313fa
Merge: 3ae3fd3 83db191
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Sat Mar 27 15:28:51 2021 +0800

    Merge remote-tracking branch 'origin/master'

commit 3ae3fd31953354fe6656ca48e1cd10343563c371
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Sat Mar 27 15:28:34 2021 +0800

    updated Player class

commit 83db19105ecdf05c47549eb83123e8edc28577b5
Merge: a6fbc20 a6e0140
Author: Yuhui Pang <u7211790@anu.edu.au>
Date:   Sat Mar 27 15:24:43 2021 +0800

    Merge remote-tracking branch 'origin/master'

commit a6fbc204923c4f01b1b0bf34228c0d5bc2674513
Author: Yuhui Pang <u7211790@anu.edu.au>
Date:   Sat Mar 27 15:24:08 2021 +0800

    Update Centre class and some changes to Discard,Factory class

commit a6e0140f942010c05f5773a2f354c2665327b011
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Sat Mar 27 15:22:38 2021 +0800

    updated Storage class

commit 582982e3dfb02947f23bae2f122a8cf382f85c10
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Sat Mar 27 15:18:20 2021 +0800

    updated Storage and Prepare class

commit e209394f35cff7e6926f345137a26fc8bc747059
Author: Yuhui Pang <u7211790@anu.edu.au>
Date:   Sat Mar 27 15:07:20 2021 +0800

    Update Discard class

commit 8e7fc5608bbcdf0479b52d9796c2e476055d76db
Author: Yuhui Pang <u7211790@anu.edu.au>
Date:   Sat Mar 27 14:53:48 2021 +0800

    Update Factory class and little change to Tile class

commit 84f1bc2a467f78ebf1fb34861898a408c4e0887b
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Sat Mar 27 14:51:31 2021 +0800

    updated Floor class

commit e46bd0e5cef4700a70b622f98e7152268de4c589
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Sat Mar 27 14:31:58 2021 +0800

    updated prepare class

commit db0db48e98d66b31d6f13377c470c1af319696fb
Author: Yuhui Pang <u7211790@anu.edu.au>
Date:   Sat Mar 27 14:15:47 2021 +0800

    Change class Tile‘s structure

commit 40a2760a6766f4d9c7c1f2e07c5abfee6937dae3
Merge: 54a10c0 48b1089
Author: Yuhui Pang <u7211790@anu.edu.au>
Date:   Sat Mar 27 14:01:16 2021 +0800

    Merge remote-tracking branch 'origin/master'

commit 54a10c0b77418c421bdd3e2e726a3242aea78be4
Author: Yuhui Pang <u7211790@anu.edu.au>
Date:   Sat Mar 27 14:00:54 2021 +0800

    Some changes to class Tile

commit 48b1089d65d16b3ed3b9b5795ac0a6527f665d81
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Thu Mar 25 11:17:35 2021 +0800

    Every member participated in the design

commit 78378d688889e4579c29e7ba7fd46eefc44c6511
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Thu Mar 25 11:06:07 2021 +0800

    Fixed TileColor

commit 18a191a1b26a05d29cf9d1030b20fbf596bab876
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Thu Mar 25 11:00:49 2021 +0800

    First design

commit 94068fe5613e7e2a7281145f7cbaa6c49ce472b1
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Thu Mar 25 10:00:09 2021 +0800

    Changed class path

commit e0a551a556d89d013c189edec23bd65a44f3f2ec
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Thu Mar 25 09:57:18 2021 +0800

    Added multiple classes

commit bd1a28a066b2d480b80fc9d12592214e34b71da0
Merge: cca51f5 82a0aa5
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Thu Mar 25 09:33:03 2021 +0800

    Merge remote-tracking branch 'origin/master'

commit cca51f5f882b77224967705cdd027bb2be158b25
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Thu Mar 25 09:32:48 2021 +0800

    Added Tile class

commit 82a0aa536274275fe90944273ec45fffeedc6006
Author: Qinling Zhong <u6616888@anu.edu.au>
Date:   Wed Mar 24 23:29:14 2021 +0800

    U6616888 Task 2

commit 5faf640298ff43082b85d192694fd0c6c01afe90
Merge: 77ebe22 c11b565
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Wed Mar 24 23:05:18 2021 +0800

    Merge branch 'master' of https://gitlab.cecs.anu.edu.au/comp1110/comp1110-ass2

commit c11b565c45fb435089e189669f88b871d8c13176
Author: Josh Milthorpe <josh.milthorpe@anu.edu.au>
Date:   Tue Mar 23 16:10:29 2021 +1100

    clarify Centre placement string including first player tile

commit 77ebe22cea68d337098ea041cbb13e4b5c43fee3
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Tue Mar 23 10:46:19 2021 +0800

    Deleted lab 5 group task

commit b1e11ac5acbb212986cbdc05e496f34ad464b707
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Tue Mar 23 10:44:10 2021 +0800

    Added meeting time for week 5

commit 0136333e955d2948844a26589d5c42e89ad899f2
Merge: b97cf78 df9a4ac
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Tue Mar 23 10:31:08 2021 +0800

    Merge remote-tracking branch 'origin/master'

commit df9a4acbf04758d19c9acde53979045cdc341524
Merge: 8b83448 578f6d8
Author: Qinling Zhong <u6616888@anu.edu.au>
Date:   Tue Mar 23 10:28:11 2021 +0800

    Merge remote-tracking branch 'origin/BobsExperiment'

commit 8b834486ff16bf23edb51bfb4a2225346cb2d5c3
Author: Qinling Zhong <u6616888@anu.edu.au>
Date:   Tue Mar 23 10:26:31 2021 +0800

    Alice

commit c0cdde8f5d739af29d0cc0056eaf5756820ff527
Author: Bob <u1234567@anu.edu.au>
Date:   Tue Mar 23 10:08:34 2021 +0800

    Add b to main!

commit 84635ab154b4704b9af4ba2ef9541a6ff7f3aa1d
Author: Qinling Zhong <u6616888@anu.edu.au>
Date:   Tue Mar 23 09:50:37 2021 +0800

    Alice

commit 578f6d83793973f4294fee69de94e99fab40a967
Author: Bob <u1234567@anu.edu.au>
Date:   Tue Mar 23 09:50:27 2021 +0800

    Add B to main!

commit b97cf7824399224ef19a8290d66316a66b9c31f0
Author: Cindy <u7111698@anu.edu.au>
Date:   Tue Mar 23 09:50:20 2021 +0800

    Added C in Main

commit 9892164177744c5d2b92c01881d3914862b7a6de
Author: Bob <u1234567@anu.edu.au>
Date:   Tue Mar 23 09:46:00 2021 +0800

    Simple change with B！

commit f4963c9cc43468c55e1571e47cf63371e9c69b3f
Merge: b60c892 a990512
Author: Yuhui Pang <u7211790@anu.edu.au>
Date:   Tue Mar 23 09:41:05 2021 +0800

    Merge remote-tracking branch 'origin/master'

commit a9905120b30a33d7b8f2b854406b4a89c1f2e58d
Author: Cindy <u71116708@anu.edu.au>
Date:   Tue Mar 23 09:39:35 2021 +0800

    Task 2: Separate sharedState into factories, center, bag and discard

commit b60c892b7aa1d0822340d32419a8e10c97e57aef
Author: Bob <u1234567@anu.edu.au>
Date:   Tue Mar 23 09:38:31 2021 +0800

    Add class B！

commit 072f0b7caa120749c427347bca92e9aa4c241c3a
Author: Qinling Zhong <u6616888@anu.edu.au>
Date:   Tue Mar 23 09:35:20 2021 +0800

    Alice

commit dbe2263af48e055f7e27e4c8bcc17feef30baaf9
Author: Qinling Zhong <u6616888@anu.edu.au>
Date:   Tue Mar 23 09:28:05 2021 +0800

    Git-test

commit e6daac68789f9d01bf5078379a3e07d34903adbb
Merge: 5085fd9 4f69425
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Mon Mar 22 16:46:35 2021 +0800

    Merge branch 'master' of https://gitlab.cecs.anu.edu.au/comp1110/comp1110-ass2

commit 5085fd9f2029c8a50b5f3cb9cc2dc1a516fc13b8
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Mon Mar 22 16:45:46 2021 +0800

    Task 2: Separate sharedState into factories, center, bag and discard

commit 4f694254de647ef83f37b6035256d2125a2ffe04
Author: Josh Milthorpe <josh.milthorpe@anu.edu.au>
Date:   Mon Mar 22 13:16:12 2021 +1100

    Java 15

commit ed4ae2fdbfc811b7fda9e47176f60a16603f010f
Author: Josh Milthorpe <josh.milthorpe@anu.edu.au>
Date:   Sun Mar 21 20:07:43 2021 +1100

    fix name of IsPlayerStateWellFormedTest

commit 404db87e001efec37beb6c5f4e70bf11aceaef88
Author: Josh Milthorpe <josh.milthorpe@anu.edu.au>
Date:   Sun Mar 21 20:04:47 2021 +1100

    fix name of IsPlayerStateWellFormedTest

commit 5ace7bf7e56c07e6544f7e6be2218d1c5134be99
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Sat Mar 20 21:46:57 2021 +0800

    Commented collaboration, code and assets in originality

commit 6b6787a3e3717c7362dfa05caa558103bf0cc33d
Merge: 82c69b0 dc56bc7
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Sat Mar 20 21:41:59 2021 +0800

    Merge remote-tracking branch 'origin/master'

commit 82c69b08f92b64d0bc23d298aece843ffe817dd4
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Sat Mar 20 21:40:56 2021 +0800

    Signed originality

commit dc56bc7faa03d33f9461b219b1d11cafc40c4930
Author: Yuhui Pang <u7211790@anu.edu.au>
Date:   Sat Mar 20 16:30:17 2021 +0800

    update B-originality.yml add signatures

commit b4b11d8db46486f1e274a3f77ddd5937c1902c75
Author: Yuhui Pang <u7211790@anu.edu.au>
Date:   Sat Mar 20 16:27:03 2021 +0800

    update originality.yml add signatures

commit 676bc47ba584578ad5cefb747e86c43b7e56a5bd
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Fri Mar 19 08:02:50 2021 +0800

    Added contact information in members.yml

commit 6533ec00e107db4c7037a276c443b46882ca5e70
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Tue Mar 16 11:31:18 2021 +0800

    Updated week 4 meeting time in tasks.md

commit 8bfd975736ab683ffda5ea2ea30d24459e6def04
Author: Jiawen Wang <u7111608@anu.edu.au>
Date:   Tue Mar 16 11:08:09 2021 +0800

    Added members in member.yml

commit 73783fca77459dd1248988752488e4d8e64e0fec
Author: Josh Milthorpe <josh.milthorpe@anu.edu.au>
Date:   Tue Mar 16 10:06:29 2021 +1100

    add link to game rules; cleanup task numbers

commit 9d4a5eb49c6f1970f9ed47b739ae3abddae8b8b9
Author: Josh Milthorpe <josh.milthorpe@anu.edu.au>
Date:   Tue Mar 16 01:09:23 2021 +1100

    Initial import
```
## Changes
``` diff
Only in comp1110-ass2/.idea/artifacts: comp1110_ass2_jar.xml
Only in comp1110-ass2/.idea: inspectionProfiles
diff -ru -x .git ../master/comp1110-ass2/.idea/runConfigurations/Task_10_IsMoveValidTest.xml comp1110-ass2/.idea/runConfigurations/Task_10_IsMoveValidTest.xml
--- ../master/comp1110-ass2/.idea/runConfigurations/Task_10_IsMoveValidTest.xml	2021-03-30 10:54:46.322389500 +1100
+++ comp1110-ass2/.idea/runConfigurations/Task_10_IsMoveValidTest.xml	2021-04-19 11:58:37.113096000 +1000
@@ -3,7 +3,7 @@
     <module name="comp1110-ass2" />
     <extension name="coverage">
       <pattern>
-        <option name="PATTERN" value="comp1110.ass2.*" />
+        <option name="PATTERN" value="comp1110.ass2.sharedState.*" />
         <option name="ENABLED" value="true" />
       </pattern>
     </extension>
diff -ru -x .git ../master/comp1110-ass2/.idea/runConfigurations/Task_11_ApplyMoveTest.xml comp1110-ass2/.idea/runConfigurations/Task_11_ApplyMoveTest.xml
--- ../master/comp1110-ass2/.idea/runConfigurations/Task_11_ApplyMoveTest.xml	2021-03-30 10:54:46.330698700 +1100
+++ comp1110-ass2/.idea/runConfigurations/Task_11_ApplyMoveTest.xml	2021-04-19 11:58:37.119080200 +1000
@@ -3,7 +3,7 @@
     <module name="comp1110-ass2" />
     <extension name="coverage">
       <pattern>
-        <option name="PATTERN" value="comp1110.ass2.*" />
+        <option name="PATTERN" value="comp1110.ass2.sharedState.*" />
         <option name="ENABLED" value="true" />
       </pattern>
     </extension>
diff -ru -x .git ../master/comp1110-ass2/.idea/runConfigurations/Task_2_IsSharedStateWellFormedTest.xml comp1110-ass2/.idea/runConfigurations/Task_2_IsSharedStateWellFormedTest.xml
--- ../master/comp1110-ass2/.idea/runConfigurations/Task_2_IsSharedStateWellFormedTest.xml	2021-03-30 10:54:46.338092400 +1100
+++ comp1110-ass2/.idea/runConfigurations/Task_2_IsSharedStateWellFormedTest.xml	2021-04-19 11:58:37.126997400 +1000
@@ -3,7 +3,7 @@
     <module name="comp1110-ass2" />
     <extension name="coverage">
       <pattern>
-        <option name="PATTERN" value="comp1110.ass2.*" />
+        <option name="PATTERN" value="comp1110.ass2.sharedState.*" />
         <option name="ENABLED" value="true" />
       </pattern>
     </extension>
diff -ru -x .git ../master/comp1110-ass2/.idea/runConfigurations/Task_3_IsPlayerStateWellFormedTest.xml comp1110-ass2/.idea/runConfigurations/Task_3_IsPlayerStateWellFormedTest.xml
--- ../master/comp1110-ass2/.idea/runConfigurations/Task_3_IsPlayerStateWellFormedTest.xml	2021-03-30 10:54:46.346099000 +1100
+++ comp1110-ass2/.idea/runConfigurations/Task_3_IsPlayerStateWellFormedTest.xml	2021-04-19 11:58:37.132980100 +1000
@@ -3,7 +3,7 @@
     <module name="comp1110-ass2" />
     <extension name="coverage">
       <pattern>
-        <option name="PATTERN" value="comp1110.ass2.*" />
+        <option name="PATTERN" value="comp1110.ass2.sharedState.*" />
         <option name="ENABLED" value="true" />
       </pattern>
     </extension>
diff -ru -x .git ../master/comp1110-ass2/.idea/runConfigurations/Task_5_DrawTileFromBagTest.xml comp1110-ass2/.idea/runConfigurations/Task_5_DrawTileFromBagTest.xml
--- ../master/comp1110-ass2/.idea/runConfigurations/Task_5_DrawTileFromBagTest.xml	2021-03-30 10:54:46.354102300 +1100
+++ comp1110-ass2/.idea/runConfigurations/Task_5_DrawTileFromBagTest.xml	2021-04-19 11:58:37.139577800 +1000
@@ -3,7 +3,7 @@
     <module name="comp1110-ass2" />
     <extension name="coverage">
       <pattern>
-        <option name="PATTERN" value="comp1110.ass2.*" />
+        <option name="PATTERN" value="comp1110.ass2.sharedState.*" />
         <option name="ENABLED" value="true" />
       </pattern>
     </extension>
diff -ru -x .git ../master/comp1110-ass2/.idea/runConfigurations/Task_6_RefillFactoriesTest.xml comp1110-ass2/.idea/runConfigurations/Task_6_RefillFactoriesTest.xml
--- ../master/comp1110-ass2/.idea/runConfigurations/Task_6_RefillFactoriesTest.xml	2021-03-30 10:54:46.361086100 +1100
+++ comp1110-ass2/.idea/runConfigurations/Task_6_RefillFactoriesTest.xml	2021-04-19 11:58:37.145561500 +1000
@@ -3,7 +3,7 @@
     <module name="comp1110-ass2" />
     <extension name="coverage">
       <pattern>
-        <option name="PATTERN" value="comp1110.ass2.*" />
+        <option name="PATTERN" value="comp1110.ass2.sharedState.*" />
         <option name="ENABLED" value="true" />
       </pattern>
     </extension>
diff -ru -x .git ../master/comp1110-ass2/.idea/runConfigurations/Task_7_GetBonusPointsTest.xml comp1110-ass2/.idea/runConfigurations/Task_7_GetBonusPointsTest.xml
--- ../master/comp1110-ass2/.idea/runConfigurations/Task_7_GetBonusPointsTest.xml	2021-03-30 10:54:46.368114000 +1100
+++ comp1110-ass2/.idea/runConfigurations/Task_7_GetBonusPointsTest.xml	2021-04-19 11:58:37.152543700 +1000
@@ -3,7 +3,7 @@
     <module name="comp1110-ass2" />
     <extension name="coverage">
       <pattern>
-        <option name="PATTERN" value="comp1110.ass2.*" />
+        <option name="PATTERN" value="comp1110.ass2.sharedState.*" />
         <option name="ENABLED" value="true" />
       </pattern>
     </extension>
diff -ru -x .git ../master/comp1110-ass2/.idea/runConfigurations/Task_9_IsStateValidTest.xml comp1110-ass2/.idea/runConfigurations/Task_9_IsStateValidTest.xml
--- ../master/comp1110-ass2/.idea/runConfigurations/Task_9_IsStateValidTest.xml	2021-03-30 10:54:46.376046100 +1100
+++ comp1110-ass2/.idea/runConfigurations/Task_9_IsStateValidTest.xml	2021-04-19 11:58:37.160348100 +1000
@@ -3,7 +3,7 @@
     <module name="comp1110-ass2" />
     <extension name="coverage">
       <pattern>
-        <option name="PATTERN" value="comp1110.ass2.*" />
+        <option name="PATTERN" value="comp1110.ass2.sharedState.*" />
         <option name="ENABLED" value="true" />
       </pattern>
     </extension>
diff -ru -x .git ../master/comp1110-ass2/.idea/runConfigurations/Viewer.xml comp1110-ass2/.idea/runConfigurations/Viewer.xml
--- ../master/comp1110-ass2/.idea/runConfigurations/Viewer.xml	2021-03-30 10:54:46.383043500 +1100
+++ comp1110-ass2/.idea/runConfigurations/Viewer.xml	2021-05-21 09:01:39.301534400 +1000
@@ -5,7 +5,7 @@
     <option name="VM_PARAMETERS" value="--module-path ${PATH_TO_FX} --add-modules=javafx.controls,javafx.fxml,javafx.media" />
     <extension name="coverage">
       <pattern>
-        <option name="PATTERN" value="comp1110.ass2.gui.*" />
+        <option name="PATTERN" value="comp1110.ass2.gui.Group.*" />
         <option name="ENABLED" value="true" />
       </pattern>
     </extension>
Only in comp1110-ass2/.idea: vcs.xml
Only in comp1110-ass2/.idea: workspace.xml
diff -ru -x .git ../master/comp1110-ass2/README.md comp1110-ass2/README.md
--- ../master/comp1110-ass2/README.md	2021-04-19 11:58:35.350297800 +1000
+++ comp1110-ass2/README.md	2021-04-19 11:58:37.167328800 +1000
@@ -13,7 +13,7 @@
 In this assignment, you will work as a group to master a number of major themes of this course,
 including software design and implementation,
 using development tools such as Git and IntelliJ, and using JavaFX to build a user interface.
-As an extension task, you may also explore strategies for writing agents that play games.
+As an extension task, you may also explore strategies for writing agents that playerState games.
 Above all, this assignment will emphasize group work;
 while you will receive an individual mark for your work based on your contributions to the assignment,
 you can only succeed if all members contribute to your group's success.
@@ -60,7 +60,7 @@
 
 ## Game setup
 
-Each player has their own board on which they will play. Each board contains:
+Each player has their own board on which they will playerState. Each board contains:
 - five storage *rows*;
 - a *Floor* area; and
 - a *Mosaic* area.
@@ -453,7 +453,7 @@
 
 * you use Java and JavaFX,
 * the game respects the specification of the game given here,
-* the game be easy to play,
+* the game be easy to playerState,
 * it runs in a 1280x768 window, and
 * that it is executable on the VDI from a JAR file called `game.jar`,
 
diff -ru -x .git ../master/comp1110-ass2/admin/B-contribution.yml comp1110-ass2/admin/B-contribution.yml
--- ../master/comp1110-ass2/admin/B-contribution.yml	2021-03-30 10:54:46.400370000 +1100
+++ comp1110-ass2/admin/B-contribution.yml	2021-03-30 11:06:56.038278800 +1100
@@ -8,19 +8,19 @@
 # be 100 or 99 (33/33/33 is fine).  (Remove entries if you have fewer than three
 # members).  
 contributions:
-  - uid: 
-    contribution: 
-  - uid:
-    contribution:
-  - uid:
-    contribution:
+  - uid: u7211790
+    contribution: 33
+  - uid: u6616888
+    contribution: 33
+  - uid: u7111608
+    contribution: 33
 
 # Sign *your* name and uids here. (Remove entries if you have fewer
 # than three members)
 signatures:
-  - name:
-    uid:
-  - name:
-    uid:
-  - name:
-    uid:
\ No newline at end of file
+  - name: Yuhui Pang
+    uid: u7211790
+  - name: Qinling Zhong
+    uid: u6616888
+  - name: Jiawen Wang
+    uid: u7111608
\ No newline at end of file
diff -ru -x .git ../master/comp1110-ass2/admin/B-originality.yml comp1110-ass2/admin/B-originality.yml
--- ../master/comp1110-ass2/admin/B-originality.yml	2021-03-30 10:54:46.407498900 +1100
+++ comp1110-ass2/admin/B-originality.yml	2021-03-30 11:06:56.067303700 +1100
@@ -19,9 +19,9 @@
 #
 # Add as many "name+comment" entries as necessary
 # (or remove it altogether if you haven't collaborated with anyone)
-collaboration:
-  - name:
-    comment: >-
+#collaboration:
+#  - name:
+#    comment: >-
 
 # Use this to list any code that you used that you did not write,
 # aside from code provided by the lecturer.  Provide a comment
@@ -30,10 +30,10 @@
 #
 # Add as many "url+licence+comment" entries as necessary
 # (or remove it altogether if you haven't used any external code)
-code:
-  - comment:
-    url:
-    licence:
+#code:
+#  - comment:
+#    url:
+#    licence:
 
 # Use this to list any assets (artwork, sound, etc) that you used.
 # Provide a comment explaining your use of that asset and the URL
@@ -41,18 +41,18 @@
 #
 # Add as many "url+licence+comment" entries as necessary
 # (or remove it altogether if you haven't used any external assets)
-assets:
-  - comment:
-    url:
-    licence:
+#assets:
+#  - comment:
+#    url:
+#    licence:
 
 
 # Sign *your* name and uids here. (Remove entries if you have fewer
 # than three members.)
 signatures:
-  - name:
-    uid:
-  - name:
-    uid:
-  - name:
-    uid:
+  - name: Yuhui Pang
+    uid: u7211790
+  - name: Qinling Zhong
+    uid: u6616888
+  - name: Jiawen Wang
+    uid: u7111608
Only in comp1110-ass2/admin: C-best-u6616888.yml
Only in comp1110-ass2/admin: C-best-u7111608.yml
Only in comp1110-ass2/admin: C-best-u7211790.yml
diff -ru -x .git ../master/comp1110-ass2/admin/C-contribution.yml comp1110-ass2/admin/C-contribution.yml
--- ../master/comp1110-ass2/admin/C-contribution.yml	2021-03-30 10:54:46.414482800 +1100
+++ comp1110-ass2/admin/C-contribution.yml	2021-04-19 11:58:37.188176300 +1000
@@ -8,19 +8,19 @@
 # be 100 or 99 (33/33/33 is fine).  (Remove entries if you have fewer than three
 # members).  
 contributions:
-  - uid: 
-    contribution: 
-  - uid:
-    contribution:
-  - uid:
-    contribution:
+  - uid: u7211790
+    contribution: 40
+  - uid: u6616888
+    contribution: 30
+  - uid: u7111608
+    contribution: 30
 
 # Sign *your* name and uids here. (Remove entries if you have fewer
 # than three members)
 signatures:
-  - name:
-    uid:
-  - name:
-    uid:
-  - name:
-    uid:
\ No newline at end of file
+  - name: Yuhui Pang
+    uid: u7211790
+  - name: Qinling Zhong
+    uid: u6616888
+  - name: Jiawen Wang
+    uid: u7111608
\ No newline at end of file
diff -ru -x .git ../master/comp1110-ass2/admin/C-originality.yml comp1110-ass2/admin/C-originality.yml
--- ../master/comp1110-ass2/admin/C-originality.yml	2021-03-30 10:54:46.421464100 +1100
+++ comp1110-ass2/admin/C-originality.yml	2021-03-30 11:06:56.128947400 +1100
@@ -19,9 +19,9 @@
 #
 # Add as many "name+comment" entries as necessary
 # (or remove it altogether if you haven't collaborated with anyone)
-collaboration:
-  - name:
-    comment: >-
+#collaboration:
+#  - name:
+#    comment: >-
 
 # Use this to list any code that you used that you did not write,
 # aside from code provided by the lecturer.  Provide a comment
@@ -30,10 +30,10 @@
 #
 # Add as many "url+licence+comment" entries as necessary
 # (or remove it altogether if you haven't used any external code)
-code:
-  - comment:
-    url:
-    licence:
+#code:
+#  - comment:
+#    url:
+#    licence:
 
 # Use this to list any assets (artwork, sound, etc) that you used.
 # Provide a comment explaining your use of that asset and the URL
@@ -41,18 +41,18 @@
 #
 # Add as many "url+licence+comment" entries as necessary
 # (or remove it altogether if you haven't used any external assets)
-assets:
-  - comment:
-    url:
-    licence:
+#assets:
+#  - comment:
+#    url:
+#    licence:
 
 
 # Sign *your* name and uids here. (Remove entries if you have fewer
 # than three members.)
 signatures:
-  - name:
-    uid:
-  - name:
-    uid:
-  - name:
-    uid:
+  - name: Yuhui Pang
+    uid: u7211790
+  - name: Qinling Zhong
+    uid: u6616888
+  - name: Jiawen Wang
+    uid: u7111608
Only in ../master/comp1110-ass2/admin: D-newcode-u1234567.md
Only in comp1110-ass2/admin: D-newcode-u6616888.md
Only in comp1110-ass2/admin: D-newcode-u7111608.md
Only in comp1110-ass2/admin: D-newcode-u7211790.md
Only in ../master/comp1110-ass2/admin: D-originality-u1234567.yml
Only in comp1110-ass2/admin: D-originality-u6616888.yml
Only in comp1110-ass2/admin: D-originality-u7111608.yml
Only in comp1110-ass2/admin: D-originality-u7211790.yml
diff -ru -x .git ../master/comp1110-ass2/admin/E-contribution.yml comp1110-ass2/admin/E-contribution.yml
--- ../master/comp1110-ass2/admin/E-contribution.yml	2021-03-30 10:54:46.445783500 +1100
+++ comp1110-ass2/admin/E-contribution.yml	2021-05-03 08:01:12.555706300 +1000
@@ -8,19 +8,19 @@
 # be 100 or 99 (33/33/33 is fine).  (Remove entries if you have fewer than three
 # members).  
 contributions:
-  - uid: 
-    contribution: 
-  - uid:
-    contribution:
-  - uid:
-    contribution:
+  - uid: u7211790
+    contribution: 33
+  - uid: u6616888
+    contribution: 33
+  - uid: u7111608
+    contribution: 33
 
 # Sign *your* name and uids here. (Remove entries if you have fewer
 # than three members)
 signatures:
-  - name:
-    uid:
-  - name:
-    uid:
-  - name:
-    uid:
\ No newline at end of file
+  - name: Yuhui Pang
+    uid: u7211790
+  - name: Qinling Zhong
+    uid: u6616888
+  - name: Jiawen Wang
+    uid: u7111608
\ No newline at end of file
diff -ru -x .git ../master/comp1110-ass2/admin/E-originality.yml comp1110-ass2/admin/E-originality.yml
--- ../master/comp1110-ass2/admin/E-originality.yml	2021-03-30 10:54:46.452770600 +1100
+++ comp1110-ass2/admin/E-originality.yml	2021-03-30 11:06:56.252941300 +1100
@@ -19,9 +19,9 @@
 #
 # Add as many "name+comment" entries as necessary
 # (or remove it altogether if you haven't collaborated with anyone)
-collaboration:
-  - name:
-    comment: >-
+#collaboration:
+#  - name:
+#    comment: >-
 
 # Use this to list any code that you used that you did not write,
 # aside from code provided by the lecturer.  Provide a comment
@@ -30,10 +30,10 @@
 #
 # Add as many "url+licence+comment" entries as necessary
 # (or remove it altogether if you haven't used any external code)
-code:
-  - comment:
-    url:
-    licence:
+#code:
+#  - comment:
+#    url:
+#    licence:
 
 # Use this to list any assets (artwork, sound, etc) that you used.
 # Provide a comment explaining your use of that asset and the URL
@@ -41,18 +41,18 @@
 #
 # Add as many "url+licence+comment" entries as necessary
 # (or remove it altogether if you haven't used any external assets)
-assets:
-  - comment:
-    url:
-    licence:
+#assets:
+#  - comment:
+#    url:
+#    licence:
 
 
 # Sign *your* name and uids here. (Remove entries if you have fewer
 # than three members.)
 signatures:
-  - name:
-    uid:
-  - name:
-    uid:
-  - name:
-    uid:
+  - name: Yuhui Pang
+    uid: u7211790
+  - name: Qinling Zhong
+    uid: u6616888
+  - name: Jiawen Wang
+    uid: u7111608
Only in ../master/comp1110-ass2/admin: E-review-u1234567.md
Only in comp1110-ass2/admin: E-review-u6616888.md
Only in comp1110-ass2/admin: E-review-u7111608.md
Only in comp1110-ass2/admin: E-review-u7211790.md
Only in ../master/comp1110-ass2/admin: F-best-u1234567.yml
Only in comp1110-ass2/admin: F-best-u6616888.yml
Only in comp1110-ass2/admin: F-best-u7111608.yml
Only in comp1110-ass2/admin: F-best-u7211790.yml
diff -ru -x .git ../master/comp1110-ass2/admin/F-contribution.yml comp1110-ass2/admin/F-contribution.yml
--- ../master/comp1110-ass2/admin/F-contribution.yml	2021-03-30 10:54:46.476703300 +1100
+++ comp1110-ass2/admin/F-contribution.yml	2021-05-21 09:01:39.330469800 +1000
@@ -10,19 +10,19 @@
 # be 100 or 99 (33/33/33 is fine).  (Remove entries if you have fewer than three
 # members).
 contributions:
-  - uid: 
-    contribution: 
-  - uid:
-    contribution:
-  - uid:
-    contribution:
+  - uid: u7211790
+    contribution: 35
+  - uid: u6616888
+    contribution: 30
+  - uid: u7111608
+    contribution: 35
 
 # Sign *your* name and uids here. (Remove entries if you have fewer
 # than three members)
 signatures:
-  - name:
-    uid:
-  - name:
-    uid:
-  - name:
-    uid:
+  - name: Yuhui Pang
+    uid: u7211790
+  - name: Qinling Zhong
+    uid: u6616888
+  - name: Jiawen Wang
+    uid: u7111608
diff -ru -x .git ../master/comp1110-ass2/admin/F-features.md comp1110-ass2/admin/F-features.md
--- ../master/comp1110-ass2/admin/F-features.md	2021-03-30 10:54:46.483684700 +1100
+++ comp1110-ass2/admin/F-features.md	2021-05-21 09:01:39.337599800 +1000
@@ -1,7 +1,7 @@
 In addition to the features that are auto-graded, the graphical user interface
 of our project implements the following features:
 
-*(Remove those that are unimplemented)*
+
 
  - A simple placement viewer (Task 4)
  - A basic playable game
@@ -10,3 +10,8 @@
  - Implements interesting game variant/s (Task 16)
 
 additional features...
+
+
+- Background pictures and background music 
+- Hierarchy menu
+- Mouse click effect
diff -ru -x .git ../master/comp1110-ass2/admin/F-originality.yml comp1110-ass2/admin/F-originality.yml
--- ../master/comp1110-ass2/admin/F-originality.yml	2021-03-30 10:54:46.490666000 +1100
+++ comp1110-ass2/admin/F-originality.yml	2021-05-21 09:01:39.344602200 +1000
@@ -19,9 +19,9 @@
 #
 # Add as many "name+comment" entries as necessary
 # (or remove it altogether if you haven't collaborated with anyone)
-collaboration:
-  - name:
-    comment: >-
+#collaboration:
+#  - name:
+#    comment: >-
 
 # Use this to list any code that you used that you did not write,
 # aside from code provided by the lecturer.  Provide a comment
@@ -31,9 +31,13 @@
 # Add as many "url+licence+comment" entries as necessary
 # (or remove it altogether if you haven't used any external code)
 code:
-  - comment:
-    url:
-    licence:
+  - comment: refered to last year's ass1 dinosaurs to add sound effect and bgm
+    url: N/A
+    licence: All right reserved
+
+  - comment: refered to Almas Baimagambetov's YouTube video "JavaFX Custom Game Menu - Thief" to add the game menu
+    url: https://www.youtube.com/watch?v=aOcow70vqb4&ab_channel=AlmasBaimagambetov
+    licence: All right reserved
 
 # Use this to list any assets (artwork, sound, etc) that you used.
 # Provide a comment explaining your use of that asset and the URL
@@ -42,17 +46,40 @@
 # Add as many "url+licence+comment" entries as necessary
 # (or remove it altogether if you haven't used any external assets)
 assets:
-  - comment:
-    url:
-    licence:
+  - comment: Menu background music, Yugen - Emotional Ethnic Music by Keys of Moon
+      url: https://soundcloud.com/keysofmoon
+      licence: Attribution 4.0 International (CC BY 4.0)
+
+  - comment: Game background music, {Old Bossa} by Twin Musicom
+    url: http://www.twinmusicom.org/
+    licence: Attribution 4.0 International (CC BY 4.0)
+
+  - comment: click sound 1
+    url: https://sc.chinaz.com/yinxiao/180904492042.htm
+    licence: CopyRight 2002-2020
+
+  - comment: click sound 3,
+    url: https://sc.chinaz.com/yinxiao/171122209170.htm
+    licence: CopyRight 2002-2020
+
+  - comment: game menu background, image published by W. Eric Martin in website boardgamegeek
+      url: https://boardgamegeek.com/image/3718275/azul
+      licence: Attribution 3.0 Unported (CC BY 3.0)
+
+  - comment: game background, image published by illustratelife in www.vecteezy.com
+      url: https://www.vecteezy.com/vector-art/273835-white-background
+      licence: Attribution 3.0 Unported (CC BY 3.0)
 
+  - comment: game rule, images in the rulebook
+      url: https://www.boardgamecapital.com/game_rules/azul.pdf
+      licence: Attribution 3.0 Unported (CC BY 3.0)
 
 # Sign *your* name and uids here. (Remove entries if you have fewer
 # than three members.)
 signatures:
-  - name:
-    uid:
-  - name:
-    uid:
-  - name:
-    uid:
+  - name: Yuhui Pang
+    uid: u7211790
+  - name: Qinling Zhong
+    uid: u6616888
+  - name: Jiawen Wang
+    uid: u7111608
diff -ru -x .git ../master/comp1110-ass2/admin/G-originality.yml comp1110-ass2/admin/G-originality.yml
--- ../master/comp1110-ass2/admin/G-originality.yml	2021-03-30 10:54:46.505626100 +1100
+++ comp1110-ass2/admin/G-originality.yml	2021-03-30 11:06:56.483306900 +1100
@@ -19,9 +19,9 @@
 #
 # Add as many "name+comment" entries as necessary
 # (or remove it altogether if you haven't collaborated with anyone)
-collaboration:
-  - name:
-    comment: >-
+#collaboration:
+#  - name:
+#    comment: >-
 
 # Use this to list any code that you used that you did not write,
 # aside from code provided by the lecturer.  Provide a comment
@@ -30,10 +30,10 @@
 #
 # Add as many "url+licence+comment" entries as necessary
 # (or remove it altogether if you haven't used any external code)
-code:
-  - comment:
-    url:
-    licence:
+#code:
+#  - comment:
+#    url:
+#    licence:
 
 # Use this to list any assets (artwork, sound, etc) that you used.
 # Provide a comment explaining your use of that asset and the URL
@@ -41,18 +41,18 @@
 #
 # Add as many "url+licence+comment" entries as necessary
 # (or remove it altogether if you haven't used any external assets)
-assets:
-  - comment:
-    url:
-    licence:
+#assets:
+#  - comment:
+#    url:
+#    licence:
 
 
 # Sign *your* name and uids here. (Remove entries if you have fewer
 # than three members.)
 signatures:
-  - name:
-    uid:
-  - name:
-    uid:
-  - name:
-    uid:
+  - name: Yuhui Pang
+    uid: u7211790
+  - name: Qinling Zhong
+    uid: u6616888
+  - name: Jiawen Wang
+    uid: u7111608
\ No newline at end of file
diff -ru -x .git ../master/comp1110-ass2/admin/members.yml comp1110-ass2/admin/members.yml
--- ../master/comp1110-ass2/admin/members.yml	2021-03-30 10:54:46.519588600 +1100
+++ comp1110-ass2/admin/members.yml	2021-03-30 11:06:56.518631800 +1100
@@ -3,9 +3,12 @@
 #
 
 members:
-  - name:
-    uid:
-  - name:
-    uid:
-  - name:
-    uid:
+  - name: Yuhui Pang
+    uid: u7211790
+    contact: u7211790@anu.edu.au
+  - name: Qinling Zhong
+    uid: u6616888
+    contact: u6616888@anu.edu.au
+  - name: Jiawen Wang
+    uid: u7111608
+    contact: u7111608@anu.edu.au
diff -ru -x .git ../master/comp1110-ass2/admin/tasks.md comp1110-ass2/admin/tasks.md
--- ../master/comp1110-ass2/admin/tasks.md	2021-03-30 10:54:46.526605500 +1100
+++ comp1110-ass2/admin/tasks.md	2021-05-03 08:01:12.630506000 +1000
@@ -4,29 +4,52 @@
 Use the entries below as an example.
 
 ## Week 4
+meeting time: 14:00 16 Mar
 
-Everyone: create application skeleton - meeting 14:00 19 Mar
+Everyone: cloned group repo and added members in members.yml.
 
 ## Week 5
+meeting time: 12:00 25 Mar
 
-Zhang San: Task 3 isPlayerStateWellFormed - 23 Mar
+Everyone: Discuss the skeleton design
 
-Jane Bloggs: Task 5 drawTileFromBag - 23 Mar
+meeting time: 13:30 27 Mar
 
-Erika Mustermann: Task 6 refillFactories - 25 Mar (depends on Task 5)
+Everyone: Finished skeleton including all the classes and methods
 
 ## Week 6
 
-...
+meeting time: 15:00 30 Mar
+
+Everyone: Decide responsibilities of each member for Part one
 
 ## Mid-Semester Break
+meeting time: 14:00 16 Apr
+
+Everyone: Working on Part One of the assignment
+
+Yuhui Pang: Mainly focus on Task 4, 7 and 8
+
+Qinling Zhong: Mainly focus on Task 2 and 3
+
+Jiawen Wang: Mainly focus on Task 5 and 6
 
 ## Week 7
+D2C: Assignment 2, Stage C due Monday 7:00
 
 ## Week 8
+D2D: Assignment 2, Stage D due Monday 7:00
+
+Meeting time: 9:00 29 Apr
 
+Everyone: package the program as a JAR file called game.jar and discuss the reviewers for each member's code.
 ## Week 9
+D2E: Assignment 2, Stage E due Monday 7:00
 
 ## Week 10
 
 ## Week 11
+D2F: Assignment 2, Stage F due Friday 9:45
+
+## Week 12
+D2G: Assignment 2, Stage G due Monday 7:00
\ No newline at end of file
Only in comp1110-ass2: feedback
Only in comp1110-ass2: feedback.md
Only in comp1110-ass2: game.jar
Only in comp1110-ass2: markertmp
Only in comp1110-ass2: out
Only in comp1110-ass2/src: META-INF
diff -ru -x .git ../master/comp1110-ass2/src/comp1110/ass2/Azul.java comp1110-ass2/src/comp1110/ass2/Azul.java
--- ../master/comp1110-ass2/src/comp1110/ass2/Azul.java	2021-04-19 11:58:35.359892300 +1000
+++ comp1110-ass2/src/comp1110/ass2/Azul.java	2021-05-21 09:01:39.626639100 +1000
@@ -1,7 +1,27 @@
 package comp1110.ass2;
 
+import comp1110.ass2.Tile.Tile;
+import comp1110.ass2.playerState.Mosaic;
+import comp1110.ass2.playerState.PlayerState;
+import comp1110.ass2.playerState.Storage;
+import comp1110.ass2.sharedState.SharedState;
+
+import java.util.*;
+
 public class Azul {
+
+
+    public static SharedState sharedState;
+    public static PlayerState[] playerState;
+
+    public static String lastShareState;
+    public static String lastPlayerState;
+
+
+
     /**
+     * @author Qinling Zhong and Yuhui Pang
+     *
      * Given a shared state string, determine if it is well-formed.
      * Note: you don't need to consider validity for this task.
      * A sharedState is well-formed if it satisfies the following conditions.
@@ -58,12 +78,15 @@
      * @return true if sharedState is well-formed, otherwise return false
      * TASK 2
      */
-    public static boolean isSharedStateWellFormed(String sharedState) {
-        // FIXME Task 2
-        return false;
+    public static boolean isSharedStateWellFormed(String sharedState) { // FIXME Task 2
+
+        return SharedState.isWellFormed(sharedState);
+
     }
 
     /**
+     * @author Qinling Zhong and Yuhui Pang
+     *
      * Given a playerState, determine if it is well-formed.
      * Note: you don't have to consider validity for this task.
      * A playerState is composed of individual playerStrings.
@@ -112,12 +135,15 @@
      * false if the playerState is not well-formed
      * TASK 3
      */
-    public static boolean isPlayerStateWellFormed(String playerState) {
-        // FIXME Task 3
-        return false;
+    public static boolean isPlayerStateWellFormed(String playerState) { // FIXME Task 3
+
+        return PlayerState.isWellFormed(playerState);
+
     }
 
     /**
+     * @author Yuhui Pang and Jiawen Wang
+     *
      * Given the gameState, draw a *random* tile from the bag.
      * If the bag is empty, refill the the bag with the discard pile and then draw a tile.
      * If the discard pile is also empty, return 'Z'.
@@ -128,10 +154,28 @@
      */
     public static char drawTileFromBag(String[] gameState) {
         // FIXME Task 5
-        return '0';
+        int playerNum = PlayerState.getPlayNumber(gameState[1]);
+        //{"AFCB1915161614D0000000000", "A0MS0d11c22b33e44e1FefB0MS0a11b22d33c2F"}
+        String sharedStateStr = gameState[0];
+        sharedState = new SharedState(sharedStateStr,playerNum);
+
+        if (sharedState.getBag().isEmpty() && sharedState.getDiscard().isEmpty()) {
+            return 'Z';
+        }
+        else if(!sharedState.getBag().isEmpty()){
+            return sharedState.getBag().addToFactory().getTILE_TYPE();
+        }
+        else{
+            sharedState.getBag().getTilesFromDiscard(sharedState.getDiscard().moveTileToBag());
+            return sharedState.getBag().addToFactory().getTILE_TYPE();
+        }
+
+
     }
 
     /**
+     * @author Yuhui Pang and Jiawen Wang
+     *
      * Given a state, refill the factories with tiles.
      * If the factories are not all empty, return the given state.
      *
@@ -142,10 +186,28 @@
      */
     public static String[] refillFactories(String[] gameState) {
         // FIXME Task 6
-        return null;
+        // get player number
+        int playerNum = PlayerState.getPlayNumber(gameState[1]);
+
+        //{"AFCB1915161614D0000000000", "A0MS0d11c22b33e44e1FefB0MS0a11b22d33c2F"}
+        sharedState = new SharedState(gameState[0],playerNum);
+
+        if (sharedState.getFactory().isEmpty() && sharedState.getCentre().isEmpty()) {
+            Tile[] tiles = new Tile[4 * (2 * playerNum + 1)];
+            for (int i = 0; i < tiles.length; i++) {
+                char tileChar = drawTileFromBag(gameState);
+                tiles[i] = Tile.CharToTile(tileChar);
+                gameState[0] = sharedState.getStateStr();
+            }
+            sharedState.getFactory().getFromBag(tiles);
+            gameState[0] = sharedState.getStateStr();
+        }
+        return gameState;
     }
 
     /**
+     * @author Yuhui Pang
+     *
      * Given a gameState for a completed game,
      * return bonus points for rows, columns, and sets.
      *
@@ -157,10 +219,16 @@
      */
     public static int getBonusPoints(String[] gameState, char player) {
         // FIXME Task 7
-        return -1;
+        //{"AFCB1915161614D0000000000", "A0MS0d11c22b33e44e1FefB0MS0a11b22d33c2F"}
+
+        playerState = PlayerState.getAllPlayerStates(gameState[1]);
+
+        return playerState[player - 'A'].getBonusPoint();
     }
 
     /**
+     * @author Yuhui Pang
+     *
      * Given a valid gameState prepare for the next round.
      * 1. Empty the floor area for each player and adjust their score accordingly (see the README).
      * 2. Refill the factories from the bag.
@@ -177,10 +245,58 @@
      */
     public static String[] nextRound(String[] gameState) {
         // FIXME TASK 8
-        return null;
+        int playerNum = PlayerState.getPlayNumber(gameState[1]);
+        //Initialization the shareState and playerState
+        sharedState = new SharedState(gameState[0],playerNum);
+        playerState = PlayerState.getAllPlayerStates(gameState[1]);
+
+        //get the next player
+        char nextPlayer = PlayerState.getNextPlayer(playerState);
+
+        //Check if is the next round status
+        for (int i = 0; i < playerNum; i++) {
+            if(playerState[i].getStorage().hasFullRow()) return gameState;
+        }
+        if (!sharedState.getFactory().isEmpty() || !sharedState.getCentre().isEmpty()) return gameState;
+
+        //update the shareState
+        for (int i = 0; i < playerNum; i++) {
+            //Lose points by floor
+            playerState[i].getPlayer().updateScore(playerState[i].getFloor().getLostPoint());
+            if (playerState[i].isFirstPlayer()) {
+                sharedState.getCentre().getFirstPlayerTileFromFloor();
+            }
+            sharedState.getDiscard().getTileFromFloor(playerState[i].getFloor().moveTilesToDiscard());
+        }
+
+        sharedState.setPlayer(nextPlayer);
+        gameState[0] = sharedState.getStateStr();
+
+        //Update playerState
+        //if the end of game get the bonus points and do not need to refill factories
+        boolean isEnd = false;
+        for (int i = 0; i < playerNum; i++) {
+            if (playerState[i].isEndOfGame()) {
+                isEnd = true;
+                break;
+            }
+        }
+
+        if (isEnd) {
+            for (int i = 0; i < playerNum; i++) {
+                playerState[i].getPlayer().updateScore(playerState[i].getBonusPoint());
+            }
+        } else {
+            refillFactories(gameState);
+        }
+        gameState[0] = sharedState.getStateStr();
+        gameState[1] = PlayerState.getAllStateStr(playerState);
+
+        return gameState;
     }
 
     /**
+     * @author Qinling Zhong
      * Given an entire game State, determine whether the state is valid.
      * A game state is valid if it satisfies the following conditions.
      * <p>
@@ -215,11 +331,35 @@
      * TASK 9
      */
     public static boolean isStateValid(String[] gameState) {
+        //[General]
+        if (!isSharedStateWellFormed(gameState[0])) return false;
+        if (!isPlayerStateWellFormed(gameState[1])) return false;
+        PlayerState[] playerStates = PlayerState.getAllPlayerStates(gameState[1]);
+        SharedState sharedState = new SharedState(gameState[0], playerStates.length);
+        int[] tilesNum = sharedState.getTotalNumOfTiles();
+        for (PlayerState value : playerStates) {
+            for (int j = 0; j < 6; j++) {
+                tilesNum[j] += value.getTotalNumOfTiles()[j];
+            }
+        }
+        for (int i = 0; i < 5; i++) {
+            if(tilesNum[i] != 20) return false;
+        }
+        if(tilesNum[5] != 1) return false;
+
+        //[Mosaic] & [Storage] & [Floor]
+        for (PlayerState state : playerStates) {
+            if (!state.isStateValid()) return false;
+        }
+        return true;
+
         // FIXME Task 9
-        return false;
+
     }
 
     /**
+     * @author Jiawen Wang
+     *
      * Given a valid gameState and a move, determine whether the move is valid.
      * A Drafting move is a 4-character String.
      * A Drafting move is valid if it satisfies the following conditions:
@@ -246,10 +386,60 @@
      */
     public static boolean isMoveValid(String[] gameState, String move) {
         // FIXME Task 10
-        return false;
+        int playerNum = PlayerState.getPlayNumber(gameState[1]);
+        sharedState = new SharedState(gameState[0],playerNum);
+        playerState = PlayerState.getAllPlayerStates(gameState[1]);
+        if (sharedState.getPlayer() != move.charAt(0)) return false;
+
+        PlayerState playerState1 = playerState[move.charAt(0) - 'A'];
+        Storage storage = playerState1.getStorage();
+        Mosaic mosaic = playerState1.getMosaic();
+
+        if (move.length() == 4) {
+            char pickingFrom = move.charAt(1);
+            char tileType = move.charAt(2);
+            char placedTo = move.charAt(3);
+
+            boolean pickingValid = true;
+            boolean placingValid = true;
+
+            // 1. The specified factory/centre contains at least one tile of the specified colour.
+            if (pickingFrom == 'C') {
+                if (!sharedState.getCentre().atLeastOneTile(tileType)) pickingValid =  false;
+            } else if (!sharedState.getFactory().atLeastOneTile(tileType,pickingFrom-'0')) pickingValid = false;
+
+            // 2. The storage row the tile is being placed in does not already contain a different colour.
+            // 3. The corresponding mosaic row does not already contain a tile of that colour.
+            if (placedTo != 'F') {
+                int rowPlaced = placedTo - '0';
+                placingValid = storage.isValidPlacement(tileType, rowPlaced) && !mosaic.rowIsContained(tileType, rowPlaced);
+            }
+            return pickingValid && placingValid;
+        } else {
+            int rowPick = move.charAt(1) - '0';
+            char colPut = move.charAt(2);
+
+            // 1. The specified row in the Storage area is full.
+            if (!storage.rowIsComplete(rowPick)) return false;
+
+            // 2. The specified column does not already contain a tile of the same colour.
+            // 3. The specified location in the mosaic is empty.
+            char tileType = storage.getTileType()[rowPick].getTILE_TYPE();
+            if (colPut != 'F') {
+                return mosaic.isValidPlacement(tileType, rowPick, colPut - '0');
+            } else {
+                // if there is a valid move to the mosaic area, then the placement cannot be F
+                for (int c = 0; c < Mosaic.WIDTH; c++) {
+                    if (mosaic.isValidPlacement(tileType, rowPick, c)) return false;
+                }
+                return true;
+            }
+        }
     }
 
     /**
+     * @author Yuhui Pang
+     *
      * Given a gameState and a move, apply the move to the gameState.
      * If the move is a Tiling move, you must also update the player's score.
      * If the move is a Tiling move, you must also empty the remaining tiles
@@ -269,20 +459,235 @@
      * TASK 11
      */
     public static String[] applyMove(String[] gameState, String move) {
+        //Drafting move:B1a1 BCa1 BCaF...
+        //Tiling move:A30
+
+//        //Initialization the shareState and playerState
+//        if(lastShareState == null || lastShareState.equals(sharedState.getStateStr())){
+//            sharedState = new SharedState(gameState[0]);
+//            lastShareState = sharedState.getStateStr();
+//        }
+//        if(lastPlayerState == null || lastPlayerState.equals(PlayerState.getAllStateStr(playerState))){
+//            playerState = PlayerState.getAllPlayerStates(gameState[0]);
+//            lastPlayerState = PlayerState.getAllStateStr(playerState);
+//        }
+        if (!isMoveValid(gameState, move)) return gameState;
+        int playerNum = PlayerState.getPlayNumber(gameState[1]);
+        sharedState = new SharedState(gameState[0],playerNum);
+        playerState = PlayerState.getAllPlayerStates(gameState[1]);
+
+        char player = move.charAt(0);
+        if (move.length() == 4) {
+            char pickingFrom = move.charAt(1);
+            char tileType = move.charAt(2);
+            char placedTo = move.charAt(3);
+
+            //select tiles from centre
+            if(pickingFrom == 'C'){
+                if(sharedState.getCentre().hasFirst()) playerState[player-'A'].getFloor().addTilesToFloor(sharedState.getCentre().selectTilesFromCentre('f'),'f');
+                int selectTilesNum = sharedState.getCentre().selectTilesFromCentre(tileType);
+                moveTileToFloorOrStorage(player, tileType, placedTo, selectTilesNum);
+            }
+            //select tiles from factory
+            else{
+                Tile[] factoryRemain = sharedState.getFactory().remainTilesToCentre(pickingFrom-'0',tileType);
+                sharedState.getCentre().addTiles(factoryRemain);
+                int selectTilesNum =sharedState.getFactory().selectTilesFromFactory(pickingFrom-'0',tileType);
+                moveTileToFloorOrStorage(player, tileType, placedTo, selectTilesNum);
+            }
+            if(!sharedState.getFactory().isEmpty() || !sharedState.getCentre().isEmpty()){
+                sharedState.nextPlayer();
+            }
+        }
+        // Tiling move: A30,A3F
+        else{
+            int pickingFrom = move.charAt(1) - '0';
+            char placedTo = move.charAt(2);
+
+            char tileType = playerState[player-'A'].getStorage().getTileTypeByRow(pickingFrom);
+            if(placedTo == 'F'){
+                //Storage to Floor
+                moveTileToFloorOrStorage(player, tileType, placedTo, pickingFrom);
+            }
+            else{
+                //Storage to Mosaic
+                playerState[player-'A'].getMosaic().tillingTileToMosaic(tileType,pickingFrom,placedTo-'0');
+                sharedState.getDiscard().getTileFromStorage(tileType,pickingFrom);
+                playerState[player-'A'].getPlayer().updateScore(playerState[player-'A'].getMosaic().getTillingScore(pickingFrom,placedTo-'0'));
+                if(!playerState[player-'A'].getStorage().hasFullRow()) sharedState.nextPlayer();
+            }
+        }
+        String[] newState = new String[2];
+        newState[0] = sharedState.getStateStr();
+        newState[1] = PlayerState.getAllStateStr(playerState);
         // FIXME Task 11
-        return null;
+        return newState;
     }
 
     /**
+     * @author Yuhui Pang
+     *
+     * Move tile to Floor or storage
+     *
+     * @param player the char represented current player
+     * @param tileType the moving tile type
+     * @param placedTo the moving place to
+     * @param selectTilesNum the number of selected tiles
+     */
+    private static void moveTileToFloorOrStorage(char player, char tileType, char placedTo, int selectTilesNum) {
+        if(placedTo == 'F'){
+            //select tiles to Floor ACaF
+            Tile[] remainTiles = playerState[player-'A'].getFloor().getRemainTiles(selectTilesNum,tileType);
+            playerState[player-'A'].getFloor().addTilesToFloor(selectTilesNum,tileType);
+            if(remainTiles.length !=0) sharedState.getDiscard().getTileFromFloor(remainTiles);
+        }
+        else{
+            //select tiles to Storage ACa1
+            int remainTilesNum = playerState[player-'A'].getStorage().getRemainTiles(placedTo - '0',selectTilesNum,tileType);
+            playerState[player-'A'].getStorage().addTilesToStorage(placedTo - '0',selectTilesNum,tileType);
+            if(remainTilesNum > 0){
+                Tile[] remainTiles = playerState[player-'A'].getFloor().getRemainTiles(remainTilesNum,tileType);
+                playerState[player-'A'].getFloor().addTilesToFloor(remainTilesNum,tileType);
+                if(remainTiles.length !=0) sharedState.getDiscard().getTileFromFloor(remainTiles);
+            }
+        }
+    }
+
+    /**
+     * @author Jiawen Wang
+     *
      * Given a valid game state, return a valid move.
      *
-     * @param gameState the game state
+     * @param gameState the game state strings
      * @return a move for the current game state.
      * TASK 13
      */
     public static String generateAction(String[] gameState) {
         // FIXME Task 13
-        return null;
+        ArrayList<String> allMoves = getAllValidMoves(gameState);
+        //Random rand = new Random();
+        //int randomIndex = rand.nextInt(allMoves.size());
+        //return allMoves.get(randomIndex);
         // FIXME Task 15 Implement a "smart" generateAction()
+        char player = gameState[0].charAt(0);
+        int playerNum = PlayerState.getPlayNumber(gameState[1]);
+        sharedState = new SharedState(gameState[0],playerNum);
+        String bestMove = allMoves.get(0);
+        boolean isTillingMove = sharedState.getFactory().isEmpty() && sharedState.getCentre().isEmpty();
+
+        for (int i = 1; i < allMoves.size(); i++) {
+            String[] oldNextState = applyMove(gameState, bestMove);
+            String[] newNextState = applyMove(gameState, allMoves.get(i));
+            // tilling move: find the move with the highest score
+            if (isTillingMove) {
+                int oldBestScore = PlayerState.getAllPlayerStates(oldNextState[1])[player - 'A'].getPlayer().getScore();
+                int newNextScore = PlayerState.getAllPlayerStates(newNextState[1])[player - 'A'].getPlayer().getScore();
+                if (oldBestScore < newNextScore) {
+                    bestMove = allMoves.get(i);
+                }
+
+            // drafting move: find the mpve with the highest heuristic
+            } else {
+                int oldBestHeuristic = draftingHeuristic(oldNextState, player);
+                int newNextHeuristic = draftingHeuristic(newNextState, player);
+                if (oldBestHeuristic < newNextHeuristic) {
+                    bestMove = allMoves.get(i);
+                }
+            }
+
+        }
+        return bestMove;
+    }
+
+    /**
+     * @author Jiawen Wang
+     *
+     * Evaluate the current gamestate according to the player's storage area.
+     * This method is called to find the best draftingMove.
+     *
+     * The player board is evaluated by:
+     * number of complete rows * 10 - number of tiles in the floor
+     *
+     * @param gameState the game state strings
+     * @return player board score
+     */
+    public static int draftingHeuristic(String[] gameState, char player) {
+        PlayerState playerState = PlayerState.getAllPlayerStates(gameState[1])[player - 'A'];
+        // count the number of complete row
+        Storage storage = playerState.getStorage();
+        int countCompleteRow = 0;
+        for (int r = 0; r < Storage.NUMBER_ROWS; r++) {
+            if (storage.rowIsComplete(r)) countCompleteRow++;
+        }
+        // count number of tiles in the floor
+        int floorTileNum = playerState.getFloor().getNumber();
+        return countCompleteRow * 10 - floorTileNum;
+    }
+
+    /**
+     * @author Jiawen Wang
+     *
+     * Get all valid moves according to a valid game state.
+     *
+     * @param gameState the game state strings
+     * @return all valid moves
+     */
+    public static ArrayList<String> getAllValidMoves(String[] gameState) {
+        int playerNum = PlayerState.getPlayNumber(gameState[1]);
+        sharedState = new SharedState(gameState[0],playerNum);
+        playerState = PlayerState.getAllPlayerStates(gameState[1]);
+        char player = sharedState.getPlayer();
+        ArrayList<String> allMoves = new ArrayList<>();
+
+        // tilling move
+        if (sharedState.getFactory().isEmpty() && sharedState.getCentre().isEmpty()) {
+            int firstCompleteRow = -1;
+            for (int r = 0; r < 5; r++) {
+                if (playerState[player-'A'].getStorage().rowIsComplete(r)) {
+                    firstCompleteRow = r;
+                    break;
+                }
+            }
+            for (int c = 0 ; c < 5; c++) {
+                String move = player + "" + firstCompleteRow + c;
+                if (isMoveValid(gameState, move)) {
+                    allMoves.add(move);
+                }
+            }
+        } else { // drafting move
+            // from factory
+            for (int n = 0; n < 2*playerNum+1; n++) {
+                for (Tile tile : sharedState.getFactory().uniqueTileTypes(n)) {
+                    if (tile != null) {
+                        // to floor
+                        String facToFlo = player + "" + n + tile.getTILE_TYPE() + 'F';
+                        if (isMoveValid(gameState, facToFlo)) allMoves.add(facToFlo);
+                        // to storage
+                        for (int r = 0; r < 5; r++) {
+                            String facToSto = player + "" + n + tile.getTILE_TYPE() + "" + r;
+                            if (!playerState[player-'A'].getStorage().rowIsComplete(r) && isMoveValid(gameState, facToSto)) {
+                                allMoves.add(facToSto);
+                            }
+                        }
+                    }
+                }
+            }
+            // from centre
+            for (Tile tile : sharedState.getCentre().uniqueTileType()) {
+                if (tile != null) {
+                    // to floor
+                    String cenToFlo = player + "C" + tile.getTILE_TYPE() + 'F';
+                    if (isMoveValid(gameState, cenToFlo)) allMoves.add(cenToFlo);
+                    // to storage
+                    for (int r = 0; r < 5; r++) {
+                        String cenToSto = player + "C" + tile.getTILE_TYPE() + "" + r;
+                        if (!playerState[player-'A'].getStorage().rowIsComplete(r) && isMoveValid(gameState, cenToSto)) {
+                            allMoves.add(cenToSto);
+                        }
+                    }
+                }
+            }
+        }
+        return allMoves;
     }
 }
Only in comp1110-ass2/src/comp1110/ass2: Tile
diff -ru -x .git ../master/comp1110-ass2/src/comp1110/ass2/gui/Game.java comp1110-ass2/src/comp1110/ass2/gui/Game.java
--- ../master/comp1110-ass2/src/comp1110/ass2/gui/Game.java	2021-03-30 10:54:46.637177400 +1100
+++ comp1110-ass2/src/comp1110/ass2/gui/Game.java	2021-05-21 09:01:39.636638500 +1000
@@ -1,24 +1,699 @@
 package comp1110.ass2.gui;
 
+import comp1110.ass2.Azul;
+import comp1110.ass2.gui.Group.PlayerGroup;
+import comp1110.ass2.gui.Group.SharedGroup;
+import comp1110.ass2.gui.Group.Square;
+import comp1110.ass2.playerState.Mosaic;
+import comp1110.ass2.playerState.PlayerState;
+import comp1110.ass2.playerState.Storage;
+import comp1110.ass2.sharedState.SharedState;
 import javafx.application.Application;
+import javafx.beans.value.ObservableValue;
+import javafx.geometry.Pos;
 import javafx.scene.Group;
+import javafx.scene.Node;
+import javafx.scene.Parent;
 import javafx.scene.Scene;
+import javafx.scene.control.*;
+import javafx.scene.effect.DropShadow;
+import javafx.scene.effect.GaussianBlur;
+import javafx.scene.effect.Glow;
+import javafx.scene.image.Image;
+import javafx.scene.image.ImageView;
+import javafx.scene.input.KeyCode;
+import javafx.scene.layout.HBox;
+import javafx.scene.layout.StackPane;
+import javafx.scene.layout.VBox;
+import javafx.scene.media.AudioClip;
+import javafx.scene.paint.Color;
+import javafx.scene.paint.Paint;
+import javafx.scene.shape.Rectangle;
+import javafx.scene.text.Font;
+import javafx.scene.text.FontWeight;
+import javafx.scene.text.Text;
+import javafx.scene.text.TextAlignment;
 import javafx.stage.Stage;
 
+import java.util.ArrayList;
+import java.util.Arrays;
+
 public class Game extends Application {
     /* board layout */
-    private static final int BOARD_WIDTH = 1200;
-    private static final int BOARD_HEIGHT = 700;
+    private static final int BOARD_WIDTH = 1280;
+    private static final int BOARD_HEIGHT = 768;
+    /* menu position */
+    private static final int MENU_X = 1000;
+    private static final int MENU_Y = 480;
+
+    private static final Group root = new Group();
+    public static final Group allState = new Group();
+    private static final Group ruleGroup = new Group();
+
+    public static String[] gameState;
+    public static SharedState sharedState;
+    public static PlayerState[] playerStates;
+    public static Square.DraggableSquare draggableSquare;
+    private static Paint preColor;
+    private static Square targetSquare;
+    private static Square highlighted;
+    private static GameMenu gameMenu;
+
+    /* where to find media assets */
+    private static final String URI_BASE = "assets/";
+
+    /* menu page background */
+    private static final String MENU_BACKGROUND_URI = Game.class.getResource(URI_BASE + "azul.png").toString();
+    private static final String GAME_BACKGROUND_URI = Game.class.getResource(URI_BASE + "game.jpg").toString();
+
+    /* sound effects from https://sc.chinaz.com/yinxiao/ */
+    private static final AudioClip score = new AudioClip(Game.class.getResource(URI_BASE + "click1.mp3").toString());
+    private static final AudioClip snap = new AudioClip(Game.class.getResource(URI_BASE + "click3.mp3").toString());
+
+    /* Loop in public domain CC 0 https://soundcloud.com/keysofmoon */
+    private static final String MENU_LOOP_URI = Game.class.getResource(URI_BASE + "Yugen-Emotional-Ethnic-Music.mp3").toString();
+    /* Loop in public domain CC 0 http://www.twinmusicom.org/ */
+    private static final String GAME_LOOP_URI = Game.class.getResource(URI_BASE + "Twin Musicom - Old Bossa.mp3").toString();
+
+    private static AudioClip gameLoop;
+    private static AudioClip menuLoop;
+    private static boolean gameLoopPlaying = true;
+
+    // Game settings
+    public static boolean variantMosaic = false;
+    public static int playerNum;
+    public static boolean playWithComputer = false;
+
+    /* index for selecting rules images */
+    private static int index = 0;
+    /* images of the rules */
+    private static Image [] images = {
+            new Image(Game.class.getResource(URI_BASE + "Rule0.png").toString()),
+            new Image(Game.class.getResource(URI_BASE + "Rule1.png").toString()),
+            new Image(Game.class.getResource(URI_BASE + "Rule2.png").toString()),
+            new Image(Game.class.getResource(URI_BASE + "Rule3.png").toString()),
+            new Image(Game.class.getResource(URI_BASE + "Rule4.png").toString()),
+            new Image(Game.class.getResource(URI_BASE + "Rule5.png").toString())
+    };
+
+    /**
+     * @author Jiawen Wang, Yuhui Pang
+     *
+     * View the rules image given a index
+     * @param index index of the images
+     */
+    private static void showRulesImage(int index) {
+        ImageView imageView = new ImageView();
+        imageView.setImage(images[index % images.length]);
+        imageView.setFitWidth(BOARD_HEIGHT);
+        imageView.setFitHeight(BOARD_HEIGHT);
+        imageView.setX((BOARD_WIDTH - BOARD_HEIGHT) / 2.0);
+        ruleGroup.getChildren().clear();
+        addBackground(MENU_BACKGROUND_URI,0.1,ruleGroup);
+        ruleGroup.getChildren().add(imageView);
+    }
+
+    /**
+     * @author Yuhui Pang
+     *
+     * Initialise game boards according to the player number, size of the square, space between the squares
+     * and whether player with computer
+     * @param playerNum number of players
+     * @param size size of the square
+     * @param space space between the squares
+     * @param flag whether player with computer
+     */
+    private static void gameInitialization(int playerNum, int size, int space, boolean flag){
+        Game.playerNum = playerNum;
+        Square.SIZE = size;
+        Square.SPACE = space;
+        playWithComputer = flag;
+        score.play();
+        menuLoop.stop();
+        root.getChildren().clear();
+        addBackground(GAME_BACKGROUND_URI,0.3,root);
+        root.getChildren().add(allState);
+        startGame();
+        setUpSoundLoop();
+        gameLoop.play();
+        gameLoopPlaying = true;
+    }
+
+    /**
+     * @author Yuhui Pang, Jiawen Wang
+     *
+     * Class for the game menu, add buttons to select play and show rules
+     */
+    private static class GameMenu extends Parent {
+        public GameMenu() {
+            VBox menu0 = new VBox(10);
+            VBox menu1 = new VBox(10);
+            VBox menu2 = new VBox(10);
+            menu0.setTranslateX(MENU_X);
+            menu0.setTranslateY(MENU_Y);
+            menu1.setTranslateX(MENU_X);
+            menu1.setTranslateY(MENU_Y);
+            menu2.setTranslateX(MENU_X);
+            menu2.setTranslateY(MENU_Y);
+            addBackground(MENU_BACKGROUND_URI,1,root);
+            menuSoundLoop();
+            menuLoop.play();
+            // Play button and its sub-buttons
+            MenuButton butPlay = new MenuButton("Play");
+            butPlay.setOnMouseClicked(event -> {
+                score.play();
+                getChildren().clear();
+                getChildren().add(menu1);
+            });
+            MenuButton butTwoPlayer = new MenuButton("Two Players");
+            butTwoPlayer.setOnMouseClicked(event -> {
+                gameInitialization(2,40,5,false);
+            });
+            MenuButton butThreePlayer = new MenuButton("Three Players");
+            butThreePlayer.setOnMouseClicked(event -> {
+                gameInitialization(3,30,3,false);
+            });
+            MenuButton butFourPlayer = new MenuButton("Four Players");
+            butFourPlayer.setOnMouseClicked(event -> {
+                gameInitialization(4,30,3,false);
+            });
+            MenuButton butComp = new MenuButton("Play with Computer");
+            butComp.setOnMouseClicked(event -> {
+                gameInitialization(2,40,5,true);
+            });
+
+            MenuButton botExist = new MenuButton("Exist");
+            botExist.setOnMouseClicked(event -> System.exit(0));
+
+            VBox radioGroup = new VBox();
+            radioGroup.setSpacing(10);
+            ToggleGroup group = new ToggleGroup();
+            MenuRadioButton button1 = new MenuRadioButton("Beginner Mosaic");
+            button1.setToggleGroup(group);
+            button1.setSelected(true);
+            button1.setUserData("Beginner");
+            MenuRadioButton button2 = new MenuRadioButton("Variant Mosaic");
+            button2.setToggleGroup(group);
+            button2.setUserData("Variant");
+
+            group.selectedToggleProperty().addListener(
+                    (ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) -> {
+                        if (group.getSelectedToggle() != null) {
+                            variantMosaic = group.getSelectedToggle().getUserData().toString().equals("Variant");
+                            score.play();
+                        }
+                });
+            radioGroup.getChildren().addAll(button1,button2);
+
+            MenuButton butPlayBack = new MenuButton("Back");
+            butPlayBack.setOnMouseClicked(event -> {
+                score.play();
+                getChildren().clear();
+                getChildren().add(menu0);
+            });
+            // Rules button and its sub-buttons
+            MenuButton butRules = new MenuButton("Rules");
+            butRules.setOnMouseClicked(event -> {
+                score.play();
+                getChildren().clear();
+                showRulesImage(index);
+                getChildren().addAll(ruleGroup,menu2);
+            });
+            MenuButton butNextPage = new MenuButton("Next Page");
+            butNextPage.setOnMouseClicked(event -> {
+                index++;
+                score.play();
+                getChildren().clear();
+                showRulesImage(index);
+                getChildren().addAll(ruleGroup,menu2);
+            });
+            MenuButton butRuleBack = new MenuButton("Back");
+            butRuleBack.setOnMouseClicked(event -> {
+                score.play();
+                index = 0;
+                getChildren().clear();
+                getChildren().add(menu0);
+            });
+
+            MenuButton butExist = new MenuButton("Exist");
+            butExist.setOnMouseClicked(event -> System.exit(0));
+
+            menu0.getChildren().addAll(butPlay,butRules,butExist);
+            menu1.getChildren().addAll(radioGroup,butTwoPlayer,butThreePlayer,butFourPlayer,butComp,butPlayBack);
+            menu2.getChildren().addAll(butNextPage,butRuleBack);
+            getChildren().add(menu0);
+        }
+    }
+
+    /**
+     * @author Yuhui Pang
+     *
+     * Class for radio button
+     */
+    private static class MenuRadioButton extends RadioButton{
+        public MenuRadioButton(String name){
+            super(name);
+            this.setFont(Font.font("Times New Roman", FontWeight.SEMI_BOLD,20));
+            DropShadow ds = new DropShadow();
+            ds.setOffsetY(3.0);
+            ds.setColor(Color.BLACK);
+            this.setTextFill(Color.WHITE);
+            this.setEffect(ds);
+        }
+    }
+
+    /**
+     * @author Jiawen Wang
+     *
+     * Class for the menu button
+     */
+    private static class MenuButton extends StackPane {
+        private final Text text;
+        public MenuButton(String name) {
+            text = new Text(name);
+            text.setFont(text.getFont().font(20));
+            text.setFill(Color.WHITE);
+            text.setFont(Font.font("Times New Roman", FontWeight.SEMI_BOLD,20));
+            // shape of the button
+            Rectangle bg = new Rectangle(250,30);
+            bg.setOpacity(0.7);
+            bg.setFill(Color.BLACK);
+            bg.setEffect(new GaussianBlur(3.5));
+            setAlignment(Pos.CENTER_LEFT);
+            setRotate(-0.5);
+            getChildren().addAll(bg,text);
+            // add effect when the mouse is positioned in the button area
+            this.setOnMouseEntered(event -> {
+                bg.setTranslateX(10);
+                text.setTranslateX(10);
+                bg.setFill(Color.WHITE);
+                text.setFill(Color.BLACK);
+            });
+            this.setOnMouseExited(event -> {
+                bg.setTranslateX(0);
+                text.setTranslateX(0);
+                bg.setFill(Color.BLACK);
+                text.setFill(Color.WHITE);
+            });
+            // add glow effect when mouse pressed the button
+            DropShadow drop = new DropShadow(50, Color.WHITE);
+            drop.setInput(new Glow());
+            this.setOnMousePressed(event -> setEffect(drop));
+            this.setOnMouseReleased(event -> setEffect(null));
+        }
+    }
+
+    /**
+     * @author Jiawen Wang, Yuhui Pang
+     *
+     * Add backgrounds
+     *
+     * @param imageURL string of the image url
+     * @param opacity opacity
+     * @param group group to be added
+     */
+    private static void addBackground(String imageURL, double opacity, Group group){
+        ImageView background = new ImageView(new Image(imageURL));
+        background.setFitWidth(BOARD_WIDTH);
+        background.setFitHeight(BOARD_WIDTH);
+        background.setY((BOARD_HEIGHT - BOARD_WIDTH) / 2.0);
+        background.setOpacity(opacity);
+        group.getChildren().add(background);
+    }
+
+    /**
+     * @author Yuhui Pang, Jiawen Wang
+     *
+     * display game state
+     */
+    public static void displayState() {
+        //Clear the group
+        allState.getChildren().clear();
+        String sharedStateStr = gameState[0];
+        String playerStateStr = gameState[1];
+
+        //Check if the input is valid
+        if(!Azul.isSharedStateWellFormed(sharedStateStr) || !Azul.isPlayerStateWellFormed(playerStateStr)){
+            System.out.println("Invalid:" + Arrays.toString(gameState));
+            new Alert(Alert.AlertType.NONE, "Invalid state!", new ButtonType[]{ButtonType.CLOSE}).show();
+            return;
+        }
+
+        //Draw playerState
+        playerStates = PlayerState.getAllPlayerStates(playerStateStr);
+        for (int i = 0; i < playerNum; i++) {
+            char player = (char) ('A' + i);
+            PlayerGroup playerGroup = new PlayerGroup(playerStates[i],player);
+
+            allState.getChildren().add(playerGroup);
+        }
+
+        //Draw shareState
+        sharedState = new SharedState(sharedStateStr,playerNum);
+        SharedGroup sharedGroup = new SharedGroup(sharedState);
+
+        allState.getChildren().add(sharedGroup);
+
+        if(playWithComputer && sharedState.getPlayer() != 'A' && (!PlayerState.isGameComplete(gameState[1]))){
+            MenuButton compTurn = new MenuButton("Click here to do next!");
+            compTurn.setLayoutX(550);
+            compTurn.setLayoutY(250);
+            compTurn.setOnMouseClicked(event -> {
+                autoTileMove();
+            });
+            allState.getChildren().add(compTurn);
+        }
+
+        MenuButton back = new MenuButton("Back to Menu");
+        back.setOnMouseClicked(event -> {
+            gameLoop.stop();
+            gameLoopPlaying = false;
+            root.getChildren().clear();
+            gameMenu = new GameMenu();
+            root.getChildren().add(gameMenu);
+            event.consume();
+        });
+        back.setLayoutX(1000);
+        back.setLayoutY(BOARD_HEIGHT - 60);
+        Text hint = new Text("Press M - Control BGM");
+        hint.setFill(Color.BLACK);
+        hint.setFont(Font.font("Times New Roman", FontWeight.SEMI_BOLD,20));
+        hint.setLayoutX(1000);
+        hint.setLayoutY(BOARD_HEIGHT - 8);
+        allState.getChildren().addAll(back,hint);
+    }
+
+    /**
+     * @author Yuhui Pang
+     *
+     * start game, refill factories and display game state
+     */
+    public static void startGame() {
+        gameState = new String[] {new SharedState(playerNum).getStateStr(),PlayerState.getAllStateStr(PlayerState.getAllPlayerStates(playerNum))};
+        Azul.refillFactories(gameState);
+        displayState();
+        System.out.println(Arrays.toString(gameState));
+    }
+
+    /**
+     * @author Yuhui Pang
+     *
+     * highlight the given nearest square
+     * @param square the nearest square
+     */
+    public static void highlightNearestSquare(Square square) {
+        Game.targetSquare = square;
+        if (highlighted != null) highlighted.setFill(preColor);
+        highlighted = square;
+        preColor = square.getFill();
+        if (highlighted.getFill() == Color.GREY) highlighted.setFill(Color.LIGHTGREY);
+    }
+
+    /**
+     * @author Yuhui Pang
+     *
+     * auto tilling move for computer opponent
+     */
+    public static void autoTileMove() {
+        String move = Azul.generateAction(gameState);
+        if(move.length() == 4){
+            gameState = Azul.applyMove(gameState,move);
+            sharedState = new SharedState(gameState[0],playerNum);
+            playerStates = PlayerState.getAllPlayerStates(gameState[1]);
+            snap.play();
+            System.out.println("auto drifting:"+ Arrays.toString(gameState));
+            System.out.println("auto drifting:"+ move);
+        }
+
+        if(!variantMosaic){
+            autoTillingMove();
+        }
+        else if(move.length() == 3){
+            tillingMove(move);
+            System.out.println("auto tilling:"+ Arrays.toString(gameState));
+            System.out.println("auto tilling:"+ move);
+        }
+        Azul.nextRound(gameState);
+        displayState();
+        checkCompletion();
+    }
+
+    /**
+     * @author Yuhui Pang
+     *
+     * move tiles, include tiling move and drafting move
+     */
+    public static void tileMove() {
+
+        //drafting move
+        if (targetSquare.position == Square.Position.Storage) {
+            char player = ((PlayerGroup) targetSquare.group).getPlayer();
+            int row = targetSquare.row;
+            draftingMove(player, (char)(row + '0'));
+        }
+        else if (targetSquare.position == Square.Position.Floor) {
+            char player = ((PlayerGroup) targetSquare.group).getPlayer();
+            draftingMove(player, 'F');
+        }
+
+        //tilling move
+        if(!variantMosaic){
+            autoTillingMove();
+        }
+        else if (targetSquare.position == Square.Position.Mosaic) {
+            char player = ((PlayerGroup) targetSquare.group).getPlayer();
+            int sRow = draggableSquare.row;
+            int mRow = targetSquare.row;
+            int mCol = targetSquare.col;
+            if(sRow == mRow){
+                String move = player + String.valueOf(sRow) + mCol;
+                tillingMove(move);
+            }
+        }
+        Azul.nextRound(gameState);
+        displayState();
+        checkCompletion();
+    }
+
+    /**
+     * @author Yuhui Pang
+     *
+     * drafting move of tiles, allow users to drag tiles and snap in the valid placement
+     * @param player char of the player
+     * @param placedTo position placed to
+     */
+    public static void draftingMove(char player, char placedTo) {
+        String move = null;
+        if (draggableSquare.position == Square.Position.Factory) {
+            int factoryNum = draggableSquare.row;
+            move = String.valueOf(player) + factoryNum + draggableSquare.tile.getTILE_TYPE() + placedTo;
+            if (Azul.isMoveValid(gameState, move)) snap.play();
+            gameState = Azul.applyMove(gameState, move);
+        }
+        else if (draggableSquare.position == Square.Position.Centre) {
+            move = String.valueOf(player) + 'C' + draggableSquare.tile.getTILE_TYPE() + placedTo;
+            if (Azul.isMoveValid(gameState, move)) snap.play();
+            gameState = Azul.applyMove(gameState, move);
+        }
+        if (move != null) {
+            sharedState = new SharedState(gameState[0],playerNum);
+            playerStates = PlayerState.getAllPlayerStates(gameState[1]);
+            System.out.println(Arrays.toString(gameState));
+            System.out.println(move);
+        }
+    }
+
+    /**
+     * @author Yuhui Pang
+     *
+     * given a move and perform tilling move
+     * @param move string representation of the move
+     */
+    private static void tillingMove(String move) {
+        if (!sharedState.getFactory().isEmpty() || !sharedState.getCentre().isEmpty()) return;
+        if(!Azul.isMoveValid(gameState,move)) return;
+        gameState = Azul.applyMove(gameState,move);
+        sharedState = new SharedState(gameState[0],playerNum);
+        playerStates = PlayerState.getAllPlayerStates(gameState[1]);
+        score.play();
+        System.out.println(Arrays.toString(gameState));
+        System.out.println(move);
+    }
+
+    /**
+     * @author Yuhui Pang
+     *
+     * Auto tilling move in beginner mosaic mode
+     */
+    public static void autoTillingMove() {
+        if (!sharedState.getFactory().isEmpty() || !sharedState.getCentre().isEmpty()) return;
+        for (PlayerState playerState : playerStates) {
+            Storage storage = playerState.getStorage();
+            char currentPlayer = playerState.getPlayer().getId();
+            sharedState.setPlayer(currentPlayer);
+            gameState[0] = sharedState.getStateStr();
+            for (int row = 0; row < 5; row++) {
+                if (storage.rowIsComplete(row)) {
+                    int col = Mosaic.getColInBeginnerMosaic(row, storage.getTileType()[row]);
+                    String move = String.valueOf(currentPlayer) + row + col;
+                    gameState = Azul.applyMove(gameState, move);
+                    playerStates = PlayerState.getAllPlayerStates(gameState[1]);
+                    sharedState = new SharedState(gameState[0], playerNum);
+                    System.out.println(Arrays.toString(gameState));
+                    System.out.println(move);
+                }
+            }
+        }
+        score.play();
+    }
+
+    /**
+     * @author Jiawen Wang
+     *
+     * Check game completion and show completion if the game is over
+     */
+    private static void checkCompletion() {
+        boolean isEnd = PlayerState.isGameComplete(gameState[1]);
+        if (isEnd) {
+            makeCompletion();
+        }
+    }
+
+    /**
+     * @author Jiawen Wang
+     *
+     * find the winner and make the completion message
+     */
+    private static void makeCompletion() {
+        ArrayList<Character> winners = PlayerState.findWinner(gameState[1]);
+        String winnersStr = "Player " + winners.get(0).toString();
+        if (winners.size() > 1) {
+            for (int i = 1; i < winners.size(); i++) {
+                winnersStr += ", Player " + winners.get(i).toString();
+            }
+        }
+        String sub;
+        if (winners.size() == playerNum) {
+            winnersStr = "";
+            sub = "draw";
+        } else if (winners.size() == 1) sub = " wins!";
+        else sub = " win!";
+
+        DropShadow drop = new DropShadow(50, Color.WHITE);
+        drop.setInput(new Glow());
+        Text message = new Text(winnersStr + sub);
+        message.setFill(Color.BLACK);
+        message.setFont(Font.font("Times New Roman", FontWeight.SEMI_BOLD,50));
+        message.setLayoutX(BOARD_WIDTH/2 - 150);
+        message.setLayoutY(BOARD_HEIGHT/2);
+        message.setEffect(drop);
+        message.setTextAlignment(TextAlignment.CENTER);
+        Text hint = new Text("Press ESC - back to the game menu");
+        hint.setFill(Color.BLACK);
+        hint.setFont(Font.font("Times New Roman", FontWeight.SEMI_BOLD,25));
+        hint.setLayoutX(BOARD_WIDTH*2/3);
+        hint.setLayoutY(BOARD_HEIGHT-50);
+        hint.setEffect(drop);
+        hint.setTextAlignment(TextAlignment.CENTER);
+        root.getChildren().addAll(hint,message);
+        MenuButton back = new MenuButton("Back to Menu");
+        back.setOnMouseClicked(event -> {
+            gameLoop.stop();
+            gameLoopPlaying = false;
+            root.getChildren().clear();
+            gameMenu = new GameMenu();
+            root.getChildren().add(gameMenu);
+            event.consume();
+        });
+        back.setLayoutX(1000);
+        back.setLayoutY(730);
+        root.getChildren().add(back);
+    }
+
+    /**
+     * @author Jiawen Wang
+     *
+     * Set up event handlers for the main game
+     * press M key for controlling music
+     * press Escape key for returning to game menu
+     *
+     * @param scene The Scene used by the game.
+     */
+    private void setUpHandlers(Scene scene) {
+        /* create handlers for key press and release events */
+        scene.setOnKeyPressed(event -> {
+            if (event.getCode() == KeyCode.M) {
+                toggleSoundLoop();
+                event.consume();
+            } else if (event.getCode() == KeyCode.ESCAPE) {
+                gameLoop.stop();
+                gameLoopPlaying = false;
+                root.getChildren().clear();
+                gameMenu = new GameMenu();
+                root.getChildren().add(gameMenu);
+                event.consume();
+            }
+        });
+    }
+
+    /**
+     * @author Jiawen Wang
+     *
+     * Set up the sound loop for the game menu
+     */
+    private static void menuSoundLoop() {
+        try {
+            menuLoop = new AudioClip(MENU_LOOP_URI);
+            menuLoop.setCycleCount(AudioClip.INDEFINITE);
+        } catch (Exception e) {
+            System.err.println(":-( something bad happened (" + MENU_LOOP_URI + "): " + e);
+        }
+    }
+
+    /**
+     * @author Jiawen Wang
+     *
+     * Set up the sound loop, idea from dinosaurs
+     */
+    private static void setUpSoundLoop() {
+        try {
+            gameLoop = new AudioClip(GAME_LOOP_URI);
+            gameLoop.setCycleCount(AudioClip.INDEFINITE);
+        } catch (Exception e) {
+            System.err.println(":-( something bad happened (" + GAME_LOOP_URI + "): " + e);
+        }
+    }
+
+    /**
+     * @author Jiawen Wang
+     *
+     * Turn the game sound loop on or off, (play after pressing M), idea from dinosaurs
+     */
+    private void toggleSoundLoop() {
+        if (gameLoopPlaying) {
+            gameLoop.stop();
+        } else if (!menuLoop.isPlaying())
+            gameLoop.play();
+        gameLoopPlaying = !gameLoopPlaying;
+    }
 
     @Override
     public void start(Stage stage) throws Exception {
         //  FIXME Task 12: Implement a basic playable Azul game in JavaFX that only allows tiles to be placed in valid places
         //  FIXME Task 14: Implement a computer opponent so that a human can play your game against the computer.
         stage.setTitle("Azul");
-        Group root = new Group();
         Scene scene = new Scene(root, BOARD_WIDTH, BOARD_HEIGHT);
 
+        gameMenu = new GameMenu();
+        root.getChildren().add(gameMenu);
+
+        //root.getChildren().add(allState);
+        setUpHandlers(scene);
+        //startGame();
+        //setUpSoundLoop();
+
         stage.setScene(scene);
         stage.show();
+
     }
 }
Only in comp1110-ass2/src/comp1110/ass2/gui: Group
diff -ru -x .git ../master/comp1110-ass2/src/comp1110/ass2/gui/Viewer.java comp1110-ass2/src/comp1110/ass2/gui/Viewer.java
--- ../master/comp1110-ass2/src/comp1110/ass2/gui/Viewer.java	2021-03-30 10:54:46.646153300 +1100
+++ comp1110-ass2/src/comp1110/ass2/gui/Viewer.java	2021-05-21 09:01:39.686363000 +1000
@@ -1,14 +1,23 @@
 package comp1110.ass2.gui;
 
+import comp1110.ass2.Azul;
+import comp1110.ass2.Tile.Tile;
+import comp1110.ass2.playerState.PlayerState;
+import comp1110.ass2.playerState.Floor;
+import comp1110.ass2.playerState.Mosaic;
+import comp1110.ass2.playerState.Player;
+import comp1110.ass2.playerState.Storage;
+import comp1110.ass2.sharedState.*;
 import javafx.application.Application;
 import javafx.event.ActionEvent;
 import javafx.event.EventHandler;
 import javafx.scene.Group;
 import javafx.scene.Scene;
-import javafx.scene.control.Button;
-import javafx.scene.control.Label;
-import javafx.scene.control.TextField;
+import javafx.scene.control.*;
 import javafx.scene.layout.HBox;
+import javafx.scene.paint.Color;
+import javafx.scene.shape.Rectangle;
+import javafx.scene.text.Font;
 import javafx.stage.Stage;
 
 public class Viewer extends Application {
@@ -21,14 +30,292 @@
     private TextField playerTextField;
     private TextField boardTextField;
 
+    public Group drawStorage(Storage storage){
+        Tile[] tileType = storage.getTileType();
+        int[] tileNum = storage.getTileNumber();
+        int side = 40;
+        int space = 5;
+        Group storageGroup = new Group();
+
+        for(int i=0;i<Storage.NUMBER_ROWS;i++){
+            int count = 0;
+            for(int j=0;j<=i;j++){
+                Rectangle r = new Rectangle();
+                r.setX((Storage.NUMBER_ROWS - j) * (side + space));
+                r.setY(i * (side + space));
+                r.setWidth(side);
+                r.setHeight(side);
+                if(tileType[i] == null || count == tileNum[i]){
+                    r.setFill(Color.GRAY);
+                }
+                else{
+                    r.setFill(tileType[i].getTILE_COLOR());
+                    count++;
+                }
+                storageGroup.getChildren().add(r);
+            }
+        }
+
+        return storageGroup;
+    }
+
+    public Group drawMosaic(Mosaic mosaic){
+        Tile[][] tiles = mosaic.getTiles();
+
+        int side = 40;
+        int space = 5;
+        Group mosaicGroup = new Group();
+
+        for(int i=0;i<Mosaic.HEIGHT;i++){
+            for(int j=0;j<Mosaic.HEIGHT;j++){
+                Rectangle r = new Rectangle();
+                r.setX(j * (side + space));
+                r.setY(i * (side + space));
+                r.setWidth(side);
+                r.setHeight(side);
+                if(tiles[i][j] == null){
+                    r.setFill(Color.GRAY);
+                }
+                else{
+                    r.setFill(tiles[i][j].getTILE_COLOR());
+                }
+                mosaicGroup.getChildren().add(r);
+            }
+        }
+
+        return mosaicGroup;
+    }
+
+    public Group drawPlayer(Player player){
+        Group playerGroup = new Group();
+        char playerId = player.getId();
+        int score = player.getScore();
+        Label labelI = new Label(String.valueOf("Player: " + playerId));
+        Label labelS = new Label(String.valueOf("Score: " + score));
+        labelI.setFont(new Font("Arial", 15));
+        labelS.setFont(new Font("Arial", 15));
+        labelS.setLayoutX(100);
+        playerGroup.getChildren().addAll(labelI,labelS);
+        return playerGroup;
+    }
+
+    public Group drawFloor( Floor floor){
+        Tile[] tiles =floor.getTiles();
+        Group floorGroup = new Group();
+        int side = 40;
+        int space = 5;
+        for(int i=0;i<Floor.MAX_LENGTH;i++){
+            Rectangle r = new Rectangle();
+            r.setX(i * (side + space));
+            r.setWidth(side);
+            r.setHeight(side);
+            if(i >= floor.getNumber() || tiles[i] == null){
+                r.setFill(Color.GRAY);
+            }
+            else{
+                r.setFill(tiles[i].getTILE_COLOR());
+            }
+            floorGroup.getChildren().add(r);
+        }
+        return floorGroup;
+    }
+
+    public Group drawFactory(Factory factory,int playerNum){
+        int factoryNum = 2 * playerNum + 1;
+        Tile[][] tiles= factory.getTiles();
+        Group factoryGroup = new Group();
+        Label label = new Label("Factory:");
+        label.setFont(new Font("Arial", 20));
+        factoryGroup.getChildren().add(label);
+        int side = 40;
+        int space = 5;
+        int distance = 20;
+        for(int i=0;i<factoryNum;i++){
+            for (int j=0;j<factory.FACTORY_CAPACITY;j++){
+                Rectangle r = new Rectangle();
+                if(j % 2 == 0){
+                    r.setX(i * (side * 2 + space + distance));
+                }
+                else{
+                    r.setX(i * (side * 2 + space + distance) + side + space);
+                }
+                r.setY((j / 2) * (side + space) + 30);
+                r.setWidth(side);
+                r.setHeight(side);
+                if(tiles[i][j] == null){
+                    r.setFill(Color.GRAY);
+                }
+                else{
+                    r.setFill(tiles[i][j].getTILE_COLOR());
+                }
+                factoryGroup.getChildren().add(r);
+            }
+        }
+        return factoryGroup;
+    }
+
+    public Group drawBag(Bag bag){
+        int[] tileNum = bag.getTile_num();
+        Group bagGroup = new Group();
+        Label label = new Label("Bag:");
+        label.setFont(new Font("Arial", 20));
+        bagGroup.getChildren().add(label);
+        int side = 40;
+        int space = 5;
+        for(int i=0;i<tileNum.length;i++){
+            Rectangle r = new Rectangle();
+            r.setX(i * (side + space));
+            r.setY(30);
+            r.setWidth(side);
+            r.setHeight(side);
+            r.setFill(Tile.idToTile(i).getTILE_COLOR());
+            Label numLabel = new Label(String.valueOf(tileNum[i]));
+            numLabel.setLayoutX(15 + i * (side + space));
+            numLabel.setLayoutY(30 + side + space);
+            bagGroup.getChildren().addAll(r,numLabel);
+        }
+        return bagGroup;
+    }
+
+    public Group drawCentre(Centre centre){
+        Tile[] tiles = centre.getTiles();
+        int num = centre.getNumber();
+        int col = 5;
+        int row = num / 5 + 1;
+        int index = 0;
+        Group centreGroup = new Group();
+        Label label = new Label("Centre:");
+        label.setFont(new Font("Arial", 20));
+        centreGroup.getChildren().add(label);
+        int side = 40;
+        int space = 5;
+        for(int i = 0;i < row;i++){
+            for(int j = 0;j < col;j++){
+                if(index < num){
+                    Rectangle r = new Rectangle();
+                    r.setX(j * (side + space));
+                    r.setY(30 + i * (side + space));
+                    r.setWidth(side);
+                    r.setHeight(side);
+                    r.setFill(tiles[index].getTILE_COLOR());
+                    index ++;
+                    centreGroup.getChildren().add(r);
+                }
+            }
+        }
+        return centreGroup;
+    }
+
+    public Group drawDiscard(Discard discard){
+        int[] tileNum = discard.getTile_num();
+        Group discardGroup = new Group();
+        Label label = new Label("Discard:");
+        label.setFont(new Font("Arial", 20));
+        discardGroup.getChildren().add(label);
+        int side = 40;
+        int space = 5;
+        for(int i=0;i<tileNum.length;i++){
+            Rectangle r = new Rectangle();
+            r.setX(i * (side + space));
+            r.setY(30);
+            r.setWidth(side);
+            r.setHeight(side);
+            r.setFill(Tile.idToTile(i).getTILE_COLOR());
+            Label numLabel = new Label(String.valueOf(tileNum[i]));
+            numLabel.setLayoutX(15 + i * (side + space));
+            numLabel.setLayoutY(30 + side + space);
+            discardGroup.getChildren().addAll(r,numLabel);
+        }
+        return discardGroup;
+    }
+
+    public Group drawPlayerTurn(char playerTurn){
+        Group playerTurnGroup = new Group();
+        Label label =new Label(String.valueOf(playerTurn) + "'s Turn");
+        label.setFont(new Font("Arial", 30));
+        if(playerTurn == 'B'){
+            label.setLayoutX(600);
+        }
+        playerTurnGroup.getChildren().add(label);
+        return playerTurnGroup;
+    }
 
     /**
+     * @author Yuhui Pang
      * Draw a placement in the window, removing any previously drawn placements
      *
      * @param state an array of two strings, representing the current game state
      *              TASK 4
      */
     void displayState(String[] state) {
+        Group allState = new Group();
+        //Clear the group
+        for(int i = 1;i < controls.getChildren().size();i++){
+            controls.getChildren().remove(i);
+        }
+        allState.getChildren().clear();
+
+        //state[0] = "A31Mb01d03e04e10c13d14d20a22b23c24e32a33b34e43S4d2FB10Ma00b01e10b12d14d20e21c30c41a44S2c23d3F";
+        //state[1] = "BF0bcdd1bbbc2aaad3acde4abceCfB0000000000D1110100612";
+        String playerStateStr = state[0];
+        String sharedStateStr = state[1];
+        //Check if  the input is valid
+        if(!Azul.isSharedStateWellFormed(sharedStateStr) || !Azul.isPlayerStateWellFormed(playerStateStr)){
+            new Alert(Alert.AlertType.NONE, "Invalid input!   Please re-enter!", new ButtonType[]{ButtonType.CLOSE}).show();
+            return;
+        }
+
+        int playerNum = PlayerState.getPlayNumber(state[0]);
+
+        //Draw playerState
+        for (int i = 0; i < playerNum; i++) {
+            if (i < playerNum - 1){
+                playerStateStr = state[0].substring(playerStateStr.indexOf((char) (i + 'A')),playerStateStr.indexOf((char) (i + 'B')));
+            }
+            else{
+                playerStateStr = state[0].substring(state[0].indexOf((char) (i + 'A')));
+            }
+
+            PlayerState playerState = new PlayerState(playerStateStr);
+            Group player = drawPlayer(playerState.getPlayer());
+            Group storage = drawStorage(playerState.getStorage());
+            Group mosaic = drawMosaic(playerState.getMosaic());
+            Group floor = drawFloor(playerState.getFloor());
+
+            storage.setLayoutX(i * 600);
+            storage.setLayoutY(280);
+            mosaic.setLayoutX(300 + i * 600);
+            mosaic.setLayoutY(280);
+            player.setLayoutX(45 + i * 600);
+            player.setLayoutY(230);
+            floor.setLayoutX(45 + i * 600);
+            floor.setLayoutY(550);
+
+            allState.getChildren().addAll(player,storage,mosaic,floor);
+        }
+
+        //Draw shareState
+        SharedState sharedState = new SharedState(sharedStateStr,playerNum);
+        Group factory = drawFactory(sharedState.getFactory(),playerNum);
+        Group bag = drawBag(sharedState.getBag());
+        Group discard = drawDiscard(sharedState.getDiscard());
+        Group centre = drawCentre(sharedState.getCentre());
+        Group playTurn = drawPlayerTurn(sharedState.getPlayer());
+
+        factory.setLayoutX(50);
+        factory.setLayoutY(0);
+        bag.setLayoutX(600);
+        bag.setLayoutY(0);
+        discard.setLayoutX(600);
+        discard.setLayoutY(100);
+        centre.setLayoutX(900);
+        centre.setLayoutY(0);
+        playTurn.setLayoutX(350);
+        playTurn.setLayoutY(220);
+
+        allState.getChildren().addAll(factory,bag,discard,centre,playTurn);
+        controls.getChildren().add(allState);
+
         // FIXME Task 4: implement the simple state viewer
     }
 
@@ -37,10 +324,10 @@
      */
     private void makeControls() {
         Label playerLabel = new Label("Player State:");
-        playerTextField = new TextField();
+        playerTextField = new TextField("A0MSFB0MSF");
         playerTextField.setPrefWidth(100);
         Label boardLabel = new Label("Board State:");
-        boardTextField = new TextField();
+        boardTextField = new TextField("AF0cdde1bbbe2abde3cdee4bcceCfB1915161614D0000000000");
         boardTextField.setPrefWidth(100);
         Button button = new Button("Refresh");
         button.setOnAction(new EventHandler<ActionEvent>() {
@@ -72,5 +359,3 @@
         primaryStage.show();
     }
 }
-
-
Only in comp1110-ass2/src/comp1110/ass2/gui: assets
Only in comp1110-ass2/src/comp1110/ass2: playerState
Only in comp1110-ass2/src/comp1110/ass2: sharedState
Only in comp1110-ass2/tests: myTest
```
