package com.company;
//  Program Pengurutan Data
//  By: Tim 4 - I2P
//  Date: 5 November 2020
//  Desc: Program pengurutan data dengan menggunakan bubble sort dan selection sort

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    static final String SEPARATOR = "-------------------------------------------------------";

            public static void main(String[] args) {
                int pilihanMenu;
                int[] angkaAcak = null;

                do {
                    pilihanMenu = 0;
                    tampilkanMenu();

                    try {
                        pilihanMenu = input.nextInt();
                    } catch (InputMismatchException ime) {
                        System.out.println("Pilihan yang dapat digunakan hanyalah 1, 2, 3, 4, 5, atau 6.");
                        input.nextLine();
                    }

                    if (pilihanMenu == 1) {
                        angkaAcak = buatAngkaAcak();
                    } else if (pilihanMenu == 2) {
                        tampilkanJudul("2. Simulasi Bubble Sort - Ascending");
                        bubbleSort(angkaAcak, true);
                    } else if (pilihanMenu == 3) {
                        tampilkanJudul("3. Simulasi Selection Sort - Ascending");
                        selectionSort(angkaAcak, true);
                    } else if (pilihanMenu == 4) {
                        tampilkanJudul("4. Simulasi Bubble Sort - Descending");
                        bubbleSort(angkaAcak, false);
                    } else if (pilihanMenu == 5) {
                        tampilkanJudul("5. Simulasi Selection Sort - Descending");
                        selectionSort(angkaAcak, false);
                    }

                } while (pilihanMenu != 6);

                input.close();
            }

            private static void tampilkanMenu() {
                System.out.println();
                System.out.println(SEPARATOR);
                System.out.println("Simulasi Pengurutan Data");
                System.out.println("1. Random Data");
                System.out.println("2. Simulasi Bubble Sort - Ascending");
                System.out.println("3. Simulasi Selecion Sort – Ascending");
                System.out.println("4. Simulasi Bubble Sort - Descending");
                System.out.println("5. Simulasi Selecion Sort – Descending");
                System.out.println("6. Keluar");
                System.out.println(SEPARATOR);
                System.out.print("Masukkan pilihan: ");
            }

            private static void tampilkanJudul(String judul) {
                System.out.println();
                System.out.println();
                System.out.println(judul);
                System.out.println(SEPARATOR);
            }

            private static int[] buatAngkaAcak() {
                tampilkanJudul("1. Random Data");

                int batasBawah = ambilMasukan(0, "Batas bawah");
                int batasAtas = ambilMasukan(batasBawah + 1, "Batas atas");
                int[] angkaAcak = new int[5];

                for (int i = 0; i < 5; i++) {
                    angkaAcak[i] = (int) ((Math.random() * (batasAtas - batasBawah)) + batasBawah);
                }

                System.out.println("Random data: " + Arrays.toString(angkaAcak));
                System.out.println();

                return angkaAcak;
            }

            private static int ambilMasukan(int nilaiMinimum, String keterangan) {
                int nilaiMasukan;

                do {
                    nilaiMasukan = nilaiMinimum - 1;
                    System.out.print("Masukkan " + keterangan + ": ");

                    try {
                        nilaiMasukan = input.nextInt();
                    } catch (InputMismatchException ime) {
                        input.nextLine();
                    }

                    if (nilaiMasukan < nilaiMinimum) {
                        System.out.println(
                                keterangan + " harus berupa angka bilangan bulat lebih besar dari " + (nilaiMinimum - 1) + ".");
                    }
                } while (nilaiMasukan < nilaiMinimum);

                return nilaiMasukan;
            }

            private static void bubbleSort(int[] angkaAcak, boolean asc) {
                if (angkaAcak == null) {
                    System.out.println("Random data belum ada, silakan pilih menu 1 (1. Random Data) terlebih dahulu.");
                    return;
                }

                int[] deretAngka = angkaAcak.clone();
                int dataSementara = 0;

                for (int i = 0; i < deretAngka.length; i++) {
                    if (i < deretAngka.length - 1) {
                        System.out.println();
                        System.out.println("Pass " + (i + 1));
                        System.out.println(Arrays.toString(deretAngka));
                    }

                    for (int j = 1; j < (deretAngka.length - i); j++) {
                        if ((asc && deretAngka[j - 1] > deretAngka[j]) || (!asc && deretAngka[j - 1] < deretAngka[j])) {
                            dataSementara = deretAngka[j - 1];
                            deretAngka[j - 1] = deretAngka[j];
                            deretAngka[j] = dataSementara;
                        }
                        System.out.println(Arrays.toString(deretAngka));
                    }

                    if (i < deretAngka.length - 1) {
                        System.out.println();
                        System.out.println("Result of Pass " + (i + 1));
                        System.out.println(Arrays.toString(deretAngka));
                    }
                }
            }

            private static void selectionSort(int[] angkaAcak, boolean asc) {
                if (angkaAcak == null) {
                    System.out.println("Random data belum ada, silakan pilih menu 1 (1. Random Data) terlebih dahulu.");
                    return;
                }

                int[] deretAngka = angkaAcak.clone();

                for (int i = 0; i < deretAngka.length - 1; i++) {
                    System.out.println();
                    System.out.println("Pass " + (i + 1));
                    System.out.println(Arrays.toString(deretAngka));

                    int posisiAngkaTerkecil = i;
                    int nilaiAngkaTerkecil = deretAngka[i];

                    for (int j = i + 1; j < deretAngka.length; j++) {
                        if ((asc && nilaiAngkaTerkecil > deretAngka[j]) || (!asc && nilaiAngkaTerkecil < deretAngka[j])) {
                            nilaiAngkaTerkecil = deretAngka[j];
                            posisiAngkaTerkecil = j;
                        }
                    }

                    if (posisiAngkaTerkecil != i) {
                        deretAngka[posisiAngkaTerkecil] = deretAngka[i];
                        deretAngka[i] = nilaiAngkaTerkecil;

                        System.out.println(Arrays.toString(deretAngka));
                    }

                    System.out.println();
                    System.out.println("Result of Pass " + (i + 1));
                    System.out.println(Arrays.toString(deretAngka));
                }
            }
    }

