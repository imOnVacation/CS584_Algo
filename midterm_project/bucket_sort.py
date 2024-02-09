def insertion_sort(bucket):
    # Loop from the second element of the array until the last element
    for i in range(1, len(bucket)):
        # The element we want to position in its correct place
        var = bucket[i]
        # Initialize the variable that will be used to find
        # the correct position of the element
        j = i - 1
        # Shift the elements of the array to create
        # the position for our element
        while j >= 0 and var < bucket[j]:
            bucket[j + 1] = bucket[j]
            j = j - 1
        # Position the element at its correct location
        bucket[j + 1] = var
    return bucket


def bucket_sort(arr):
    buckets = []
    # Find the maximum and minimum values in the array
    max_val = max(arr)
    min_val = min(arr)

    # Calculate the range and number of buckets
    bucket_range = (max_val - min_val) / len(arr)
    num_buckets = len(arr)

    # Create empty buckets
    for i in range(num_buckets):
        buckets.append([])

    # Distribute elements into buckets
    for num in arr:
        index = min(int((num - min_val) / bucket_range), num_buckets - 1)
        buckets[index].append(num)

    # Sort each bucket
    for i in range(num_buckets):
        buckets[i] = insertion_sort(buckets[i])

    # Concatenate sorted buckets to get the final sorted array
    sorted_array = [num for bucket in buckets for num in bucket]

    return sorted_array
