# CSC245_Project2_Insecure

To run, navigate to 'modify run config' and add env variable
> FILE_NAME=<PATH_HERE> 
> 
Path was canonicalized, and file naming issues were avoided by utilizing a more appropriately named key value pair, 
rather than the file name. 
Using the Env variable also aides in preventing against a Path Traversal Attack.

Strings were normalized and sanitized using Normalizer.normalize() method and StringBuilder() to hold authorized characters.

Stacktrace was removed from the system.out.println to prevent data leakage.