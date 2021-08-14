package com.lexadiky.util

val String.startsWithLetterB get() = this.first().toLowerCase() == 'b'

val String.isGrass: Boolean get() = this == "Grass"
val String.isPoison: Boolean get() = this == "Poison"
val String.isFire: Boolean get() = this == "Fire"
val String.isFlying: Boolean get() = this == "Flying"
val String.isWater: Boolean get() = this == "Water"
val String.isBug: Boolean get() = this == "Bug"
val String.isNormal: Boolean get() = this == "Normal"
val String.isElectric: Boolean get() = this == "Electric"
val String.isGround: Boolean get() = this == "Ground"
val String.isFairy: Boolean get() = this == "Fairy"
val String.isFighting: Boolean get() = this == "Fighting"
val String.isPsychic: Boolean get() = this == "Psychic"
val String.isRock: Boolean get() = this == "Rock"
val String.isSteel: Boolean get() = this == "Steel"
val String.isIce: Boolean get() = this == "Ice"
val String.isGhost: Boolean get() = this == "Ghost"
val String.isDragon: Boolean get() = this == "Dragon"
val String.isDark: Boolean get() = this == "Dark"