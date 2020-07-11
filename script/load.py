import xlrd

import sys
import os

def main(argv):
	if(len(argv)>0):
		#print('parameters:',str(argv))
		#print(argv[0])
		path = argv[0]
		if(os.path.isdir(path)):
			dirs = os.listdir(path)
			first=1
			print('<modules>')
			print('    <module >')
			for file in dirs:
				#print(os.path.join(path,file))
				workbook = xlrd.open_workbook(os.path.join(path,file))
				sheets = workbook.sheet_names()
				for sheet in sheets:
					worksheet = workbook.sheet_by_name(sheet)
					#print(worksheet.name)
					nrows = worksheet.nrows
					ncols = worksheet.ncols
					
					name = worksheet.cell(0,0).value
					if first:
						print('        <config name=\''+name+'\'>')
					
						properties = worksheet.row_values(3)
					
						for j in range(ncols):
							print('            <property name=\''+properties[j]+'\' order=\''+str(j+1)+'\' />')
						
						print('        </config>')
						
						first = 0
					
					for i in range(4,nrows):
						print('        <data ref=\''+name+'\' >')
						for j in range(ncols):
							print('            <property ref=\''+ properties[j]+'\' value= \''+ worksheet.row_values(i)[j]+'\'/>')
					
						print('        </data>')
			
		
		
			print('    </module>')
			print('</modules>')
	
if __name__=="__main__":
	main(sys.argv[1:])


