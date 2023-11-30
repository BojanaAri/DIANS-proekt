#!/bin/bash

grep -vE -- '<way.*/>' map |
sed -e '/<way.*>/,/.*<\/way>/!d' |
grep -oE -- '<way.*|<tag k="(.*name.*|email|addr:street|addr:city|addr:housenumber|opening_hours|phone|tourism)".*|</way>' |
grep -zoiP '<way.*>\n(<tag.*\n)*<tag.*v=".*[gG]alerija.*".*/>\n(<tag.*\n)*</way>\n' | 
sed --expression='s/.<way/<way/g' | 
head -n -1 | 
sed --expression 's/<//g;s=/>==g;s/>//g;s/tag.*k=//g;s/" v=/=/g' | 
awk '{
if($1 == "way")
   printf ",\n\t{\n\t\t\"%s\n\t\t\"%s\n\t\t\"%s,\n\t\t\"%s", $3, $4, $(NF-1), $NF
else if($1 == "/way")
   printf "\n\t}"
else
   printf ",\n\t\t%s", $0 }' |
sed --expression='s/="/" : "/g;s/\&amp;/\&/g;s/\&quot;//g;s/\&apos;/’/g' | 
tail -n+2 >> results.json

