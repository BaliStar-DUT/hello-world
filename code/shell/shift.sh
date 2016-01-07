#!/bin/bash
if[$#-eq 0]

then
	echo 
	echo "Usage:`basename $0`[filename]..."
	echo "At least specify one filename to remove excute permisson for group and others."
	echo 
	exit 0
fi

echo 
while [$# -gt 0]
do
	echo "Processing file '$1'."
	chmod go-x $1
	shift
done
echo "Done."
echo 
exit 0	
