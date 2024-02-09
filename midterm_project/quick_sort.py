def quick_sort(arr):
    # Base case: If the array has 1 element or is empty, it is already sorted
    if len(arr) <= 1:
        return arr

    # Choose the pivot which is the middle element of the array
    pivot = arr[len(arr) // 2]

    # Partition the array into three parts:
    # left contains elements less than the pivot
    left = [x for x in arr if x < pivot]
    # mid contains elements equal to the pivot
    mid = [x for x in arr if x == pivot]
    # right contains elements greater than the pivot
    right = [x for x in arr if x > pivot]

    # Recursively sort left and right, and combine them
    # with mid to get the sorted array
    return quick_sort(left) + mid + quick_sort(right)
