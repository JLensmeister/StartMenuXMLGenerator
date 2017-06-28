# StartMenuXMLGenerator
Generates a Windows 10 Start Menu Tile XML file from a directory of shortcuts and folders.

# Disclaimer
This was originally made specifically for a school I was working as a IT Technician for our Windows 7 to Windows 10 upgrade. I may add extra functionality in the future.

# Use
Place the jar into the root of a directory. Create a folder with your choice of name and put folders with shortcuts inside. Do not put any shortcuts in the root of the directory though. Create two folders named "SCRIPT-TopLeftGroup" and "SRIPT-TopRightGroup". The shortcuts in this folder will produce two groups at the top of the start menu along the top for direct shotcuts. The other folders in the directory will create a group with the folder name and a folder inside the group with all shortcuts inside the folder.

The XML file will be output Windows 10\<Folder name>\<Folder name>.xml

This was made for use on a Windows system and I have not tested it on other operating systems.
