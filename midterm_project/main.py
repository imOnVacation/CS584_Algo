from quick_sort import quick_sort
from heap_sort import heap_sort
from merge_sort import merge_sort
from radix_sort import radix_sort
from bucket_sort import bucket_sort
from timsort import timsort
from test_case import generate_random_array, generate_array_with_swaps
from utils import time_sorting_algorithms
import random
import math

# Modify n for size of array as needed
different_n = [1000, 10000, 100000, 1000000]
output_file = 'sorting_timings.csv'

if __name__ == '__main__':
    for n in different_n:
        # Case 1: n randomly chosen integers in the range [0...n]
        array1 = generate_random_array(n, 0, n)

        # Case 2: n randomly chosen integers in the range [0...k], k < 1000
        k = random.randint(1, 999)
        array2 = generate_random_array(n, 0, k)

        # Case 3: n randomly chosen integers in the range [0...n^3]
        array3 = generate_random_array(n, 0, n**3)

        # Case 4: n randomly chosen integers in the range [0...logn]
        array4 = generate_random_array(n, 0, int(math.log2(n)))

        # Case 5: n randomly chosen integers that are multiples of 1000 in the range [0...n]
        array5 = generate_random_array(n, 0, n)
        array5 = [num * 1000 for num in array5]

        # Case 6: the in order integers [0...n] where (logn)/2 randomly
        #         chosen values have been swapped with another value
        array6 = generate_array_with_swaps(n)

        arrays = [array1, array2, array3, array4, array5, array6]
        algorithms = [
            quick_sort, heap_sort, merge_sort, radix_sort, bucket_sort, timsort
        ]

        # Timing the sorting algorithms for each array
        time_sorting_algorithms(arrays, algorithms, output_file, n)
