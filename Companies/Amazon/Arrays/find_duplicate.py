'''
    Given an array nums containing n + 1 integers where each integer is between 1 and n 
    (inclusive), prove that at least one duplicate number must exist. 
    Assume that there is only one duplicate number, find the duplicate one. 
     
    Note:

    1) You must not modify the array (assume the array is read only).
    2) You must use only constant, O(1) extra space.
    3) Your runtime complexity should be less than O(n2).
    4) There is only one duplicate number in the array, but it could be repeated more than once.

    Refernce: Leetcode

'''


class Solution:
    # solution 1
    def findDuplicate_01(self, nums):
        """
        :type nums: List[int]
        :rtype: int

        TIME COMPLEXITY  : O(nlogn)
        SPACE COMPLEXITY : O(1) 
        
        """
        nums.sort()
        length = len(nums)
        for index in range(length-1):
            if nums[index] == nums[index+1]:
                return nums[index]
        return -1    
    
    #solution 2
    def findDuplicate_02(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        
        TIME COMPLEXITY  : O(n)
        SPACE COMPLEXITY : O(n) 
        
        """
        memory = set()
        for num in nums:
            if num in memory:
                return num
            else:
                memory.add(num)
        return -1        
