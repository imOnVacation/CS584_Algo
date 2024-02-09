def merge_sort(arr):
    # If the list is empty or contains only one element, it is already sorted
    if len(arr) <= 1:
        return arr

    # Find the middle point to divide the array into two halves
    mid = len(arr) // 2
    left = arr[:mid]
    right = arr[mid:]

    # Call merge_sort for first half and second half
    # Then merge the two halves
    return merge(merge_sort(left), merge_sort(right))


def merge(left, right):
    merged = []
    left_i, right_i = 0, 0

    # Traverse both arrays and insert smaller value from left or right
    # into result array and then increment that array index
    while left_i < len(left) and right_i < len(right):
        if left[left_i] <= right[right_i]:
            merged.append(left[left_i])
            left_i += 1
        else:
            merged.append(right[right_i])
            right_i += 1

    # If there are remaining elements in left or right half,
    # append then to the result array
    merged.extend(left[left_i:])
    merged.extend(right[right_i:])

    # return the resultant merged array
    return merged
