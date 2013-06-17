#License: MIT license
#Copyright (C) 2013 limbenjamin.com
#
#Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
#
#The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
#
#THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
#
#Instructions:
#This script checks your current IP address and updates your namecheap domain DDNS.
#Replace domain and password with the ones found in your namecheap account before use. 

add=$(date)
ip=$(curl -s checkip.dyndns.org:8245 | tr -d "a-zA-Z</>: ")
check=$(tail ip -n 1 | sed -e s/[a-zA-Z0-9\ :]*2013\ //)
if [ "$check" == "$ip" ]; then
	:	
else
	str="http://dynamicdns.park-your-domain.com/update?domain=example.com&password=password=@&ip=$ip"
	add="$add $ip"
	wget "$str" -O /dev/null
	echo $add >> ip
fi
