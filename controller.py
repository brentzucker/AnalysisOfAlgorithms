#!/usr/bin/python
import os, time
from random import randint

programs = [
	'SelectionSort', 
	'BubbleSort',
	'MergeSort',
	'QuickSort',
	'HeapSort']

input_sizes = [
	10,
	100,
	1000,
	5000,
	10000,
	100000,
	500000,
	1000000,
	5000000,
	10000000
]

TRIALS = 10
MAX_NUM = 100000000

for p in programs:

	# Reset output file
	command = '> out/{}.out'.format(p)
	os.system(command)

	for size in input_sizes:
		for trial in range(TRIALS):
			
			# Create and open input file
			f = '{}-{}.{}'.format(p, size, trial)
			input_file = 'in/{}.in'.format(f)
			fo = open(input_file, 'w+')

			# Generate Data Set
			for i in range(size):
				num = randint(0, MAX_NUM)
				# print num
				fo.write(str(num))
				fo.write(' ') # delimeter

			# Prepare to Run Java Program
			command = 'java {} {}'.format(p, input_file)
			
			# Start Timer
			start = time.time()

			# Run Java Program
			os.system(command)

			# End Timer
			end = time.time()

			time_elapsed = end - start

			# Save time elapsed
			command = 'echo "{} {}" >> out/{}.out'.format(f, time_elapsed, p)
			os.system(command)
	print 'done'

command = 'echo "Complete!" | mail brentzucker@gmail.com'
os.system(command)