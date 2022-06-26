all: poster lib images

poster:
	pdflatex poster.tex
	
lib:
	cd PhysicsExperimentLib && mvn compile install

images:
	~/anaconda3/bin/junix Calculations.ipynb -o images/