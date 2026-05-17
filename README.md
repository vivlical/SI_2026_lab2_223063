# SI_2026_lab2_223063
# Лабораториска вежба 2 по Софтверско инженерство

**Име:** Афродита Јованова  
**Индекс:** 223063

## 2. Control Flow Graphs

### Граф за функцијата `searchBookByTitle`
![CFG Search Book](sliki/searchBookByTitle.png)

### Граф за функцијата `borrowBook`
![CFG Borrow Book](sliki/borrowBook.png)

## 3. Цикломатска комплексност

Цикломатската комплексност на функциите е пресметана со помош на формулата:
**V(G) = P + 1**
каде што **P** е бројот на условни јазли. Притоа, сложените услови се разложуваат на нивните прости компоненти.

### Пресметка за `searchBookByTitle`
Во оваа функција ги имаме следниве предикатни јазли:
1. `if (title.isEmpty())` (1 прост услов)
2. `for (Book book : books)` (1 услов за итерација)
3. `if (book.getTitle().equalsIgnoreCase(title) && !book.isBorrowed())` (2 прости услови поврзани со &&)
4. `if (results.isEmpty())` (1 прост услов)

* **Вкупно предикати (P):** 1 + 1 + 2 + 1 = 5  
* **Цикломатска комплексност:** V(G) = 5 + 1 = **6**

### Пресметка за `borrowBook`
Во оваа функција ги имаме следниве предикатни јазли:
1. `if (title.isEmpty() || author.isEmpty())` (2 прости услови поврзани со ||)
2. `for (Book book : books)` (1 услов за итерација)
3. `if (book.getTitle().equalsIgnoreCase(title) && book.getAuthor().equalsIgnoreCase(author))` (2 прости услови поврзани со &&)
4. `if (book.isBorrowed())` (1 прост услов)

* **Вкупно предикати (P):** 2 + 1 + 2 + 1 = 6  
* **Цикломатска комплексност:** V(G) = 6 + 1 = **7**