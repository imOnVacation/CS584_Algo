import pandas as pd
import matplotlib.pyplot as plt

# Read the CSV data into a pandas DataFrame
data = pd.read_csv("runtime_memory_data.csv")

# Separate data for Tabulation and Memoization algorithms
tabulation_data = data[data['Algorithm'] == 'Tabulation']
memoization_data = data[data['Algorithm'] == 'Memoization']
tabulation_space_optimization_data = data[data['Algorithm']
                                          == 'Tabulation Space Optimization']


# Plotting Time Usage
plt.figure(figsize=(10, 6))
plt.subplot(1, 2, 1)

plt.plot(tabulation_data['Test Name'],
         tabulation_data['Time (nanoseconds)'],
         marker='o', label='Tabulation')
plt.plot(memoization_data['Test Name'],
         memoization_data['Time (nanoseconds)'],
         marker='o', label='Memoization')
plt.plot(tabulation_space_optimization_data['Test Name'],
         tabulation_space_optimization_data['Time (nanoseconds)'],
         marker='o', label='Tabulation Space Optimization')

plt.xlabel('Test Name')
plt.ylabel('Time (nanoseconds)')
plt.title('Time Usage Comparison')
plt.xticks(rotation=90)
plt.legend()

# Plotting Memory Usage
plt.subplot(1, 2, 2)

plt.plot(tabulation_data['Test Name'],
         tabulation_data['Memory Used (bytes)'],
         marker='o', label='Tabulation')
plt.plot(memoization_data['Test Name'],
         memoization_data['Memory Used (bytes)'],
         marker='o', label='Memoization')
plt.plot(tabulation_space_optimization_data['Test Name'],
         tabulation_space_optimization_data['Memory Used (bytes)'],
         marker='o', label='Tabulation Space Optimization')

plt.xlabel('Test Name')
plt.ylabel('Memory Used (bytes)')
plt.title('Memory Usage Comparison')
plt.xticks(rotation=90)
plt.legend()

# Adjust layout and display/save the plot
plt.tight_layout()
plt.show()
