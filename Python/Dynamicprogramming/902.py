#A recursive function that adds up result when first digit is equal
def rec(D, num):
    ebase = 0
    result = 0
    length = len(num)
    if length == 0:
        return 1
    base = len(D)
    for n in D:
        if int(n) < int(num[0]):
            ebase += 1
    if ebase != 0:
        if length > 1:
            result += ebase * base**(length -1)
        else:
            result += ebase
    if num[0] in D:
        if length > 1:
            result += rec(D, num[1:])
        elif length == 1:
            result += 1
    return result
class Solution:
    def atMostNGivenDigitSet(self, D, N):
        """
        :type D: List[str]
        :type N: int
        :rtype: int
        """
        num = str(N)
        length = len(num)
        base = len(D)
        ebase = 0
        result = 0
        for n in D:
            if int(n) < int(num[0]):
                ebase += 1
        #Ebase finds all digits that are less than first digit
        if ebase != 0:
            if length > 1:
                result += ebase * base**(length - 1)
            else:
                result += ebase
        print(result)
        b1 = 1
        #Adding up rest of combinations that is less than number of given digits
        if length > 1:
            for i in range(1, length):
                b1 = b1 * base
                result += b1
        #Call to recursive function
        if num[0] in D:
            print(rec(D, num[1:]))
            result += rec(D, num[1:])
        return result
        