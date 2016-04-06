#!/usr/bin/python
from random import randint

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

for size in input_sizes:
	for trial in range(TRIALS):
		# Create and open input file
		f = '{}.{}'.format(size, trial)
		input_file = 'in/{}.in'.format(f)
		fo = open(input_file, 'w+')

		# Generate Data Set
		for i in range(size):
			num = randint(0, MAX_NUM)
			# print num
			fo.write(str(num))
			fo.write(' ') # delimeter