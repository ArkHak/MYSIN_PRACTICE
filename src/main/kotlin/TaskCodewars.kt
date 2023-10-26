fun main() {

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


