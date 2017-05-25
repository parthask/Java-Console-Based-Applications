//package javaapp;
//
///*
//  GA.java
//
//  Definition of the class GA
//  
//  (P)2002  Dana Cristofor
//  
//*/
//
///*
//
//GAClust - Clustering categorical databases using genetic algorithms
//Copyright (C) 2002  Dana Cristofor
//
//
//This program is free software; you can redistribute it and/or modify
//it under the terms of the GNU General Public License as published by
//the Free Software Foundation; either version 2 of the License, or (at
//your option) any later version.
//
//This program is distributed in the hope that it will be useful, but
//WITHOUT ANY WARRANTY; without even the implied warranty of
//MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
//General Public License for more details.
//
//You should have received a copy of the GNU General Public License
//along with this program; if not, write to the Free Software
//Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307
//USA
//
//GAClust was written by Dana Cristofor (dana@cs.umb.edu).
//
//*/
//
//import java.util.Hashtable;
//import java.util.Random;
//import java.util.Vector;
//
///**
// * GA
// *
// * @version 	1.0
// * @author	Dana Cristofor
// */
//public class GA extends MonitoredThread
//{
//  private int N;                       // number of chromosomes
//  private int NROWS;                   // size of chromosomes
//  // number of maximum classes in the partition
//  // determined by chromosomes
//  private int K;                       
//  private Chromosome[] population;    // population of chromosomes
//  private double[] probabilities;     // selection probabilities of chromosomes
//
//  private int classFitnessType; // selects the type of class fitness
//  private int crossoverType;    // selects the type of crossover
//  private int mutationType;     // selects the type of mutation
//  private int distributionType; // selects the type of distribution
//
//  private int entropyMeasure;   // measure for fitness, can be GINI,
//				// Shannon, etc
//  private int distanceMeasure;
//
//  private int noChromCrossover; // number of chromosomes to cross over
//  private int noChromMutate;    // number of chromosomes to mutate
//
//  private int[] sample;           // selected chromosomes
//  private int sampleSize;        // size of the sample
//
//  // intersection between the best chromosome and the partitions in db
//  private Hashtable[]  intersectMap;
//
//  private double bestFitness;    // fitness of best chromosome
//  private int bestIndex;         // index of the most fit chromosome
//
//  private double fitnessThreshold; // this thresholds determines if we
//  // achieved the best acceptable fitness
//
//  private int CONSEC_NITRS;       // consecutive iterations with no improvement
//  
//  private Partition[] db;        // database
//  private int NPART;              // number of partitions in the collection db 
//  private double[] weightDBTarget; // partitions weights
//  private double[] weightTargetDB; // partitions weights
//  private double[] weight;        // partitions weights
//
//  private Random rand; // random generator
//
//  private int minimization;       // 1 if minimization, 0 if maximization
//
//  private int resType; // 0 is no results, 1 if partial results, 2 if
//		       // final results
//  private Chromosome finalChrom; // final chromosome representing the
//				 // resulting clustering
//  private int noIterations;  // final number of iterations
//
//  GA(int N, int NROWS, int K, double crossoverPct, double mutationPct, 
//     int classFitnessType, int crossoverType, int mutationType, 
//     int distributionType, int entropyMeasure, int distanceMeasure, 
//     int minimization, double fitnessThreshold, int CONSEC_NITRS, Random rand,
//     Partition[] db, int NPART, double[] weightDBTarget, 
//     double[] weightTargetDB, double[] weight, ThreadMonitor monitor)
//  {
//    this.N = N;
//    this.NROWS = NROWS;
//    this.K = K;
//    // allocate space for population of chromosomes
//    population = new Chromosome[N];
//    for (int i = 0; i < N; i++)
//      population[i] = new Chromosome(NROWS, K, classFitnessType,
//				     crossoverType, mutationType, 
//				     distributionType);
//    
//    this.classFitnessType = classFitnessType;
//    this.crossoverType = crossoverType;
//    this.mutationType = mutationType;
//    this.distributionType = distributionType;
//
//    // set number of chromosomes to cross over
//    noChromCrossover = (int)(crossoverPct*N);
//    // at least 2 chromosomes are crossed over
//    if (noChromCrossover == 0)
//      noChromCrossover = 2;
//    else
//      // make it multiple of 2  
//      if (noChromCrossover % 2 != 0)
//	noChromCrossover++;
//    
//    // set number of chromosomes to mutate
//    noChromMutate = (int)(mutationPct*N);
//    // at least one chromosome is mutated
//    if (noChromMutate == 0)
//      noChromMutate = 1;
//    
//    if (noChromMutate + noChromCrossover > N - 1)
//      {
//	System.err.println("ERROR! GA.GA(): invalid crossover and "
//			   + "mutation pctgs");
//	System.exit(1);
//      }
//
//    this.fitnessThreshold = fitnessThreshold;
//    this.CONSEC_NITRS = CONSEC_NITRS;
//    
//    // initialize the radom number generator
//    this.rand = rand;
//    
//    this.entropyMeasure = entropyMeasure;
//    this.distanceMeasure = distanceMeasure;
//    this.minimization = minimization;
//    
//    this.NPART = NPART;
//    this.db = db;
//    this.weightDBTarget = weightDBTarget;
//    this.weightTargetDB = weightTargetDB;
//    this.weight = weight;
//
//    // allocate space for probabilities
//    probabilities = new double[N];
//    sample = null;              // no selection yet
//
//    intersectMap = new Hashtable[N];
//    for (int i = 0; i < N; i++)
//      intersectMap[i] = new Hashtable();
//
//    resType = 0;
//    
//    // set the final chromosome
//    finalChrom = new Chromosome(NROWS, K, classFitnessType,
//				crossoverType, mutationType, 
//				distributionType);
//    this.monitor = monitor;
//  }
//
//  /** randomly initializes the population of chromosomes; the
//   * chromosomes will have exactly K classes */
//  private void initPopulation()
//  {
//    for (int i = 0; i < N; i++)
//      population[i].init(rand); 
//  
//    if (Global.ULTRA_VERBOSE == 1)
//      {
//	System.out.println(" Initializing population ...");
//	for (int i = 0; i < N; i++)
//	  population[i].printAM();
//
//	System.out.println("database is");
//	for (int i = 0; i < NPART; i++)
//	  db[i].printAM();
//      }
//  }
//
//  
//  /** selects <code>n</code> best chromosomes with the greatest values
//   * of their probabilities; places the indices corresponding to the
//   * selected chromosomes in the <code>sample</code> field; make the
//   * field <code>sampleSize = n</code>*/
//  private void selectBest(int n)
//  {
//    sampleSize = n ;
//    
//    // create new sample
//    sample = new int[sampleSize];
//
//    double[] fitnessValues = new double[N];
//    for (int i = 0; i < N; i++)
//      fitnessValues[i] = population[i].getFitness();
//  
//    SelectionMethods.selectBest(fitnessValues, N, minimization, 
//				sample, sampleSize);
//
//    if (Global.ULTRA_VERBOSE == 1)
//      {
//	System.out.println("Best selection");
//	for (int i = 0; i < sampleSize; i++)
//	  System.out.println(sample[i] + " " 
//			     + population[sample[i]].getFitness());
//      }
//  }
//
//  
//  /** selects <code>n</code> chromosomes with uniform probability;
//   * places the indices corresponding to the selected chromosomes in
//   * the field <code>sample</code>; makes the field <code>sampleSize =
//   * n</code> */
//  private void selectUnif(int n)
//  {
//    sampleSize = n ;
//
//    // create new sample
//    sample = new int[sampleSize];
//    SelectionMethods.selectUnif(N, sample, sampleSize, rand);
//  }
//
//
//  /** selects <code>n</code> chromosomes based on their probabilities;
//   * places the indices corresponding to the selected chromosomes in
//   * the field <code>sample</code>; makes the field <code>sampleSize =
//   * n</code> */
//  private void selectProb(int n)
//  {
//    // compute chromosome selection probabilities based on their fitness
//    computeProbabilities();
//    
//    sampleSize = n;
//
//    // create new sample
//    sample = new int[sampleSize];
//    SelectionMethods.selectProb(N, probabilities, sample, sampleSize, rand);
//  }
//
//  /** computes the cumulated probabilities associated with the
//   * chromosomes in the population these probabilities are used in the
//   * probabilistic selection of some chromosomes */
//  private void computeProbabilities()
//  {
//    if (Global.VERBOSE == 1)
//      System.out.println(" Computing probabilities ...");
//  
//    // fitness[i] is guaranteed not 
//    // to be zero at this point
//    double overallProb = 0.0;
//    for (int j = 0; j < N; j++)
//      {
//	if (minimization == 1)
//	  // make the smallest fitness value to have the greatest probability
//	  probabilities[j] = 1.0 / population[j].getFitness();
//	else
//	  probabilities[j] = population[j].getFitness();
//	
//	overallProb += probabilities[j];
//      }
//  
//    // make them real probabilities
//    // with sum equal to 1
//    for (int j = 0; j < N; j++)
//      probabilities[j] /= overallProb;
//    
//    if (Global.ULTRA_VERBOSE == 1)
//      {
//	System.out.println("prob before cumulation ");
//	for (int j = 0; j < N; j++)
//	  System.out.print(probabilities[j] + " ");
//	System.out.println();
//      }
//    
//    // finally we cumulate the probabilities 
//    // in order to make it easier
//    // to select one item randomly
//    for (int j = 1; j < N - 1; j++)
//      probabilities[j] += probabilities[j - 1];
//    probabilities[N - 1] = 1.0;
//
//    if (Global.ULTRA_VERBOSE == 1)
//      { 
//	System.out.println("prob after cumulation ");
//	for (int j = 0; j < N; j++)
//	  System.out.print(probabilities[j] + " ");
//	System.out.println();
//      }
//  }
//
//  /** selects <code>ncross</code> members of the population to
//   * crossover based on the members probabilities; pair
//   * <code>(sample[i], sample[i+1])</code> will be used to generate
//   * offsprings by crossover */
//  private void selectToCrossover()
//  {
//    if (Global.VERBOSE == 1)
//      System.out.println(" Selecting to crossover ...");
//
//    selectProb(noChromCrossover);
//
//    if (Global.VERBOSE == 1)
//      {
//	// in sample we have the selection
//	System.out.println("selected: ");
//	for (int i = 0; i < sampleSize; i++)
//	  System.out.print(sample[i] + " ");
//	System.out.println();
//      }
//  }
//
//
//  /** selects <code>nChromMutate</code> chromosomes from population to
//   * be subject to mutation */
//  private void selectToMutate()
//  {
//    if (Global.VERBOSE == 1)
//      System.out.println(" Selecting to mutate ...");
//    
//    selectUnif(noChromMutate);
//    
//    if (Global.VERBOSE == 1)
//      {
//	// in sample we have the selection
//	System.out.print("selected: ");
//	for (int i = 0; i < sampleSize; i++)
//	  System.out.println(sample[i] + " ");
//	System.out.println();
//      }
//  }
//
//
//  /** selects <code>N - noChromCrossover - noChromMutate</code> members
//   * of the population to propagate directly in the next generation;
//   * selection is based on the best values of the fitness */
//  private void selectToPropagate()
//  {
//    if (Global.VERBOSE == 1)
//      System.out.println(" Selecting to propagate ...");
//      
//    //  selectProb(N - no_chrom_crossover - no_chrom_mutate);
//    selectBest(N - noChromCrossover - noChromMutate);
//
//    if (Global.VERBOSE == 1)
//      {
//	// in sample we have the selection
//	System.out.print("selected: ");
//	for (int i = 0; i < sampleSize; i++)
//	  System.out.print(sample[i] + " ");
//	System.out.println();
//      }
//  }
//
//  /** computes most fit chromosome and its best value of fitness in
//   * the current population */
//  private void findBestFitness()
//  {
//    bestFitness = population[0].getFitness();
//    bestIndex = 0;
//  
//    double diff;
//    for (int j = 0; j < N; j++)
//      {
//	diff = population[j].getFitness() - bestFitness;
//	if ((minimization == 1 ? diff < 0: diff > 0))
//	  {
//	    bestFitness = population[j].getFitness();
//	    bestIndex = j;
//	  }
//      }
//  }
//
//  /** executes the evolve method */
//  protected void execute()
//  {
//    evolve();
//  } 
//
//  /** starts the evolution process; computes the final chromosome and
//   * the final number of iterations */
//  protected void evolve()
//  {
//    resType = 0;
//    // randomly initialize the population of chromosomes
//    initPopulation();
//
//    // check for user-requested abort
//    checkAbort();
//
//    if (Global.ULTRA_VERBOSE == 1)
//      for (int i = 0; i < N; i++)
//	population[i].print();
//
//    // define and allocate space for next population
//    Chromosome[] nextPopulation = new Chromosome[N];
//    for (int i = 0; i < N; i++)
//      nextPopulation[i] = 
//	new Chromosome(NROWS, K, classFitnessType,
//		       crossoverType, mutationType, distributionType);
//
//    // old best value or fitness
//    double oldBestFitness = 0;
//    // will hold difference between best fitnesses computed in 2
//    // successive steps
//    double deltaBestFitness;
//    
//    int startPos = 0; // index in population starting with which
//    // the fitness values should be recomputed
//
//    noIterations = 0;
//    int count = 0; // counts iterations with no improvement
//
//    while (true)
//      {
//	noIterations++;
//
//	if (Global.ULTRA_VERBOSE == 1)
//	  {
//	    System.out.println("Iteration no. " + noIterations);
//	    for (int i = 0; i < N; i++)
//	      population[i].printClassCardinalities();
//	  }
//
//	// remember the old best value of fitness
//	oldBestFitness = bestFitness;
//
//	// compute fitness and class fitness 
//	// of the chromosomes in the population
//	// for the first time use traditional computation
//	Chromosome[] tempArray = new Chromosome[N-startPos];
//	for (int i = 0; i < N-startPos; i++)
//	  tempArray[i] = population[startPos + i];
//
//	if (noIterations == 1)
//	  Chromosome.computeFitnessValues(tempArray,
//					  N - startPos, 
//					  db, NPART, 
//					  entropyMeasure, distanceMeasure,
//					  weightDBTarget, weightTargetDB, 
//					  weight);
//	else
//	  {
//	    // set the intersectMap for best Chromosome
//	    for (int i = 0; i < N; i++)
//	      intersectMap[i].clear();
//	    Partition.computeIntersections(population[0], db, NPART, 
//					   intersectMap);
//
//	    // use the efficient computation
//	    Chromosome.computeFitnessValues(population[0], intersectMap,
//					    db, NPART, 
//					    tempArray,
//					    N - startPos,	
//					    entropyMeasure, distanceMeasure,
//					    weightDBTarget, weightTargetDB, 
//					    weight);
//	  }
//
//	// check for user-requested abort
//	checkAbort();
//
//	// compute most fit chromosome and its best value of fitness
//	findBestFitness();
//
//	// check for user-requested abort
//	checkAbort();
//	
//	if (noIterations > 1)
//	  {
//	    deltaBestFitness = bestFitness - oldBestFitness;
//	    // oldBestFitness >= bestFitness
//	    if (minimization == 1 ? deltaBestFitness < 0.0 
//		: deltaBestFitness > 0.0) 
//	      count = 0;
//	    else
//	      // if this iteration was "similar" to 
//	      // the previous one increment count
//	      count++; 
//	  }
//	
//	// we found a population good enough or
//	// the populations did not improve in CONSEC_NITRS iterations
//	// exit
//	if (count >= CONSEC_NITRS)
//	  break;
//	
//	if (minimization == 1 ? bestFitness < fitnessThreshold 
//	    : bestFitness > fitnessThreshold)
//	  break;
//	
//	if (Global.VERBOSE == 1)
//	  {
//	    System.out.println();
//	    System.out.print("******* Another step in evolution ");
//	    System.out.println(noIterations + " *******");
//	    System.out.println("best fitness " + bestFitness);
//	  }
//
//	if (Global.VERBOSE == 1)
//	  System.out.println(noIterations + " " + count + " " + bestFitness);
//
//	int index = 0;
//	
//	// PROPAGATION
//	// select chromosomes that will propagate
//	// without modifications to the next generation
//	selectToPropagate();
//	
//	// copy these chromosomes to the next generation
//	// sample_size represents the number of selections in sample
//	for (int i = 0 ; i < sampleSize; i++, index++)
//	  nextPopulation[index].set(population[sample[i]]);
//
//	// check for user-requested abort
//	checkAbort();
//
//	// position from where the fitness will be computed
//	// sample_size chromosomes are from old generation
//	startPos = sampleSize;
//
//	// CROSSOVER
//	// selects the chromosomes that will be used for crossover
//	selectToCrossover();
//	
//	// performs the crossover according to crossoverType
//	// in sample we have the pairs sample[i], sample[i+1]
//	// that we will use to crossover
//	for (int i = 0; i < sampleSize - 1; i += 2)
//	  {
//	    //	    System.out.println("Before cross " + population[sample[i]].getNoClasses());
//	    // population[sample[i]].print();
//	    // population[sample[i]].printClassCardinalities();
//	    population[sample[i]].crossover(population[sample[i+1]], rand);
//	    // System.out.println("After cross " + population[sample[i]].getNoClasses());
//	    // population[sample[i]].print();
//	    // population[sample[i]].printClassCardinalities();
//	  }
//
//	// copy these chromosomes to the next generation
//	// sampleSize represents the number of selections in sample
//	for (int i = 0 ; i < sampleSize; i++, index++)
//	  nextPopulation[index].set(population[sample[i]]);
//
//	// check for user-requested abort
//	checkAbort();
//	
//	// MUTATION
//	// selects <nm> members of the population
//	// with uniform probability to be subject to mutation
//	selectToMutate();
//	
//	// performs the mutation according to mutation type
//	for (int i = 0; i < sampleSize; i++)
//	  {
//	    //	    System.out.println("Before mut " + population[sample[i]].getNoClasses());
//	    // population[sample[i]].print();
//	    population[sample[i]].mutate(rand);
//	    // System.out.println("After mut " + population[sample[i]].getNoClasses());
//	    // population[sample[i]].print();
//	  }
//	// copy these chromosomes to the next generation
//	// sampleSize represents the number of selections in sample
//	for (int i = 0 ; i < sampleSize; i++, index++)
//	  nextPopulation[index].set(population[sample[i]]);
//
//	// check for user-requested abort
//	checkAbort();
//	
//	// replace the old generation
//	for (int i = 0; i < N; i++)
//	  population[i].set(nextPopulation[i]);
//
//	// once we computed the best chromosomes in current population
//	// we have partial results
//	resType = 1;
//
//	// check for user-requested abort
//	checkAbort();
//	
//	if (Global.ULTRA_VERBOSE == 1)
//	  {
//	    for (int i = 0; i < N; i++)
//	      {
//		System.out.print("chrom " + i + " no classes " + population[i].getNoClasses() + " ");
//		population[i].printAM();
//	      }
//	    System.out.println();
//
//	    for (int j = 0; j < N; j++)
//	      {
//		System.out.print(population[j].getNoClasses() + " ");
//		population[j].printClassCardinalities();
//		System.out.println(" " + population[j].getFitness());
//	      }
//	    System.out.println();
//	  }
//      }
//
//    finalChrom.set(population[bestIndex]);
//    resType = 2;
//  }
//
//  /** returns partial or final results */
//  public Vector getResults()
//  {
//    if (isRunning)
//      throw new IllegalStateException("thread still running");
//
//    if (resType == 0)
//      throw new IllegalStateException("thread was never run");
//
//    Vector v = new Vector(2);
//    if (resType == 1)
//      // we have partial results
//      v.insertElementAt(population[0], 0);
//    else // if (resType == 2)
//      v.insertElementAt(finalChrom, 0);
//    
//    v.insertElementAt(new Integer(noIterations), 1);
//    return v;
//  }
//
//  /** returns true if the results are final, false otherwise */
//  public boolean areResultsFinal()
//  {
//    return resType == 2;
//  }
//
//    /** returns true if the results are partial, false otherwise */
//  public boolean areResultsPartial()
//  {
//    return resType == 1;
//  }
//}
