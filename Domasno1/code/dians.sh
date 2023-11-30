#!/bin/bash

echo "Filtering data from the data file and converting them to .json data"

grep -vE -- '<node.*/>' map | 
sed -e '/<node.*>/,/.*<\/node>/!d' |
grep -oE -- '<node.*|<tag k="(.*name.*|email|addr:street|addr:city|addr:housenumber|opening_hours|phone|tourism)".*|</node>' | 
grep -zoiP '<node.*>\n(<tag.*\n)*<tag.*v=".*[gG]alerija.*".*/>\n(<tag.*\n)*</node>\n' | 
sed --expression='s/.<node/<node/g' | 
head -n -1 | 
sed --expression 's/<//g;s=/>==g;s/>//g;s/tag.*k=//g;s/" v=/=/g' | 
awk '{
if($1 == "node")
   printf ",\n\t{\n\t\t\"%s\n\t\t\"%s\n\t\t\"%s,\n\t\t\"%s", $3, $4, $(NF-1), $NF
else if($1 == "/node")
   printf "\n\t}"
else
   printf ",\n\t\t%s", $0 }' |
sed --expression='s/="/" : "/g;s/\&amp;/\&/g;s/\&quot;//g;s/\&apos;/’/g' |
tail -n+2 > results.json
