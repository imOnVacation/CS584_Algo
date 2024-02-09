import csv
import time


def time_sorting_algorithms(arrays, algorithms, output_file, n):
    all_timings = []

    for algorithm in algorithms:
        timings = []
        for array in arrays:
            start_time = time.time()
            algorithm(array.copy())
            end_time = time.time()
            elapsed_time = end_time - start_time
            timings.append(elapsed_time)
        all_timings.append(timings)

    # Append timings to CSV file
    with open(output_file, 'a', newline='') as csvfile:
        writer = csv.writer(csvfile)
        writer.writerow([f'When n = {n}'] +
                        [f'Array_{i}' for i in range(1,
                                                     len(arrays) + 1)])
        for i, algorithm_timings in enumerate(all_timings):
            writer.writerow([algorithms[i].__name__] + algorithm_timings)
