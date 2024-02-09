def heapify(arr, n, i):
    # Initialize largest as root
    largest = i
    # Left child of root
    left = 2 * i + 1
    # Right child of root
    right = 2 * i + 2

    # If left child is larger than root
    if left < n and arr[left] > arr[largest]:
        largest = left

    # If right child is larger than largest so far
    if right < n and arr[right] > arr[largest]:
        largest = right

    # If largest is not root
    if largest != i:
        # Swap root and largest
        arr[i], arr[largest] = arr[largest], arr[i]
        # Heapify the root again
        heapify(arr, n, largest)


def heap_sort(arr):
    n = len(arr)

    # Build a max heap
    for i in range(n // 2 - 1, -1, -1):
        heapify(arr, n, i)

    # Extract elements from heap one by one
    for i in range(n - 1, 0, -1):
        # Swap the current root (maximum element) with the end element
        arr[i], arr[0] = arr[0], arr[i]
        # Call heapify on the reduced heap
        heapify(arr, i, 0)

    return arr
