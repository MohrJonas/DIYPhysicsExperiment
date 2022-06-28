all: poster lib images

poster:
	pdflatex poster.tex
	
lib:
	cd PhysicsExperimentLib && mvn compile install

images:
	~/anaconda3/bin/junix Calculations.ipynb -o images/

clean:
	rm -vf images/* && rm poster/poster.aux poster/poster.fls poster/poster.fdb_latexmk poster/poster.log poster/poster.synctex.gz 