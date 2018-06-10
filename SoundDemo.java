package com.elie.SoundManips;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import com.elie.SoundManips.DoublyLinkedList.EmptyListException;
import com.elie.SoundManips.DoublyLinkedList.InvalidPositionException;

public class SoundDemo {

 private static final int SAMPLE_RATE = 44100; // Sampling Rate 44.1KHz
 private static final double INVERSE_SAMPLE_RATE = 1.0 / SAMPLE_RATE; // Inverse Sample Rate 1/44100

 public static void main(String[] args) throws IOException, EmptyListException, InvalidPositionException {

  int samplesPerLoop, outputSamples;
  double sampleValue, time = 0;
  String fileName;

  Scanner scan = new Scanner(System.in);

  // file starts with one line describing the sample rate
  StringBuilder sb = new StringBuilder("; Sample Rate " + SAMPLE_RATE + "\n\n");

  System.out.println("Enter name of the file: ");
  fileName = scan.nextLine();

  File file = new File(fileName + ".dat"); // file created .dat format

  FileWriter fw = new FileWriter(file);
  BufferedWriter bw = new BufferedWriter(fw);
  PrintWriter printToFile = new PrintWriter(bw);

  System.out.print("Enter number of samples in 1 loop: ");
  samplesPerLoop = scan.nextInt();

  System.out.print("Enter number of samples in the output: ");
  outputSamples = scan.nextInt();

  SoundManips manipulator = new SoundManips(samplesPerLoop);

  System.out.println("Generating file...");
  for (int i = 0; i < outputSamples; i++) {
   sampleValue = manipulator.karplusStrong();
   sb.append(time + "\t" + sampleValue + "\n");
   time += INVERSE_SAMPLE_RATE;
  }

  printToFile.print(sb);
  System.out.println("File is created!");

  printToFile.close();
  scan.close();

 }

}
