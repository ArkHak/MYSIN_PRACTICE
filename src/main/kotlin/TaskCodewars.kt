fun main() {
    val a = intArrayOf(121, 144, 19, 161, 19, 144, 19, 11)
    val b = intArrayOf(11 * 11, 121 * 121, 144 * 144, 19 * 19, 161 * 161, 19 * 19, 144 * 144, 19 * 19)
    println(comp(a, b))
}

//Credit Card Mask
private fun maskify(str: String): String {
    return if (str.length <= 4) {
        str
    } else {
        //todo Более интересный вариант замены символов. \\w - означает любую букву, цифру или символ подчеркивания.
//        val maskedChars = str.substring(0, str.length - 4).replace("\\w".toRegex(), "#")
        val maskedChars = "#".repeat(str.length - 4)
        val newsStr = StringBuilder()
            .append(maskedChars)
            .append(str.takeLast(4))
        newsStr.toString()
    }
}

private fun findEvenIndex(arr: IntArray): Int {
    var leftSum = 0
    var rightSum = arr.sum()

    for (i in arr.indices) {
        rightSum -= arr[i]
        if (leftSum == rightSum) {
            return i
        }
        leftSum += arr[i]
    }

    return -1
}

//BackspacesInString
private fun cleanString(s: String): String {
    val newStr = StringBuilder()

    for (i in s) {
        if (i == '#') {
            newStr.deleteCharAt(newStr.lastIndex)
        } else {
            newStr.append(i)
        }
    }
    return newStr.toString()
}

//Create Phone Number
//"(123) 456-7890"
private fun createPhoneNumber(numbers: IntArray): String {
    val phoneNumber = StringBuilder()
        .append('(')
        .append(numbers.sliceArray(0..2))
        .append(") ")
        .append(numbers.sliceArray(3..5))
        .append('-')
        .append(numbers.takeLast(4))
    return phoneNumber.toString()
    //todo ещё один вариант решения
    //return String.format("(%d%d%d) %d%d%d-%d%d%d%d",
    //            numbers[0], numbers[1], numbers[2],
    //            numbers[3], numbers[4], numbers[5],
    //            numbers[6], numbers[7], numbers[8], numbers[9])
}

//Simple validation of a username with regex
private fun validateUsername(username: String): Boolean {
    val regex = "^[a-z0-9_]{4,16}$"
    return username.matches(Regex(regex))
}

//Even or Odd
private fun evenOrOdd(number: Int): String {
    return if (number % 2 == 0) "Even" else "Odd"
}

//Return Negative
private fun makeNegative(x: Int): Int = if (x > 0) -x else x

//Leap Years
private fun isLeapYear(year: Int): Boolean {
    if (year % 4 == 0) {
        if (year % 400 == 0) return true
        if (year % 100 == 0) return false
        return true
    }
    return false

    //todo Лучший вариант проверки года на leap
    //return java.time.Year.of(year).isLeap
}

//Plus - minus - plus - plus - ... - Count
private fun catchSignChange(arr: Array<Int>): Int {
    var countChangeSing = 0
    if (arr.isNotEmpty()) {
        var lastSingBoolean = arr.first() >= 0
        for (i in arr) {
            if ((i >= 0) != lastSingBoolean) {
                countChangeSing++
                lastSingBoolean = !lastSingBoolean
            }
        }
    }
    return countChangeSing

    //todo Лучший вариант
    //fun catchSignChange(arr: Array<Int>): Int = arr.map { it < 0 }
    //                                                .zipWithNext { a, b -> a != b }
    //                                                .count { it }
}

//Target Date
private fun dateNbDays(a0: Double, a: Double, p: Double): String {
    return ""
}

//Are they the "same"?
fun comp(a: IntArray?, b: IntArray?): Boolean {
    if (a?.size != null && b?.size != null && a.size == b.size) {
        a.sort()
        b.sort()
        for (i in a.indices) {
            if (a[i] * a[i] != b[i]) return false
        }
        return true
    }
    return false

    //todo лучший вариант
    // if (a == null || b == null) return false
    // return a.map { it * it }.sorted() == b.sorted()
}

