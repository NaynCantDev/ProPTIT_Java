## What is Object (Object là gì) ?
Bassically, object work like a variance. In C++, we know that `struct` allows us to create a new data type, which can then be used to create and work with a variable. So that, back to java, we have `Class` is the same with `Struct` and `object` same with `variable`.
>Về cơ bản, đối tượng (object) hoạt động giống như một biến số. Trong C++, ta biết rằng `struct` cho phép tạo ra một kiểu dữ liệu mới, và kiểu dữ liệu này sau đó được dùng để tạo và thao tác với biến. Tương tự như vậy, khi xét đến Java, ta có thể coi `Class` tương đương với `Struct`, còn `object` thì tương đương với biến.

## How Object be saved (object được lưu kiểu gì) ?
Before we go to find the answer, lets see how java organize RAM while excuting the program. In the RAM card, java seperate two zone: heap and stack. So when we declare a variable from a `CLASS` (which called `object`) and then covey value into it, we'll know that RAM will create a memory space to save the variable. In reality, the structure of a variable have two main part, its the variable's value and it's location on the RAM, and the fact is java use stack to save the location, while the heap is used to save the value. Additionally, you might be wondering "if we use basic datatype to save some value inside a function inside a class, will it save in heap with another class's value", the answer is NOT, because heap is larger than stack, it usually use for save a lot of certain value of every class, so that to access a value in heap, we need to call the value's location in stack and then find it out in heap. So to optimize the program, java use heap just to save the global variable owr the class variable while stack is used to save the location and the localized variable or a temporary variable inside a function in a class, here is the exsample:
```java
public class MemoryDemo {
    
    int id = 999; //global variable (heap)

    public void testMethod(int param) { //param is a localized variable (stack)
        
        int age = 20; //localized variable (stack)

        String str = "Hello";
        // string is a special case of localized variable, the whole str is in the stack but "Hello" itshelf is in the heap
    }
}
``` 
>Trước khi tìm câu trả lời, hãy cùng xem cách Java tổ chức bộ nhớ RAM khi thực thi chương trình. Trong RAM, Java phân chia thành hai vùng: **heap** và **stack**. Khi ta khai báo một biến từ một `CLASS` (gọi là `object`) và gán giá trị cho nó, RAM sẽ tạo ra một vùng nhớ để lưu trữ biến đó. Thực tế, cấu trúc của một biến bao gồm hai phần chính: giá trị của biến và vị trí của nó trong RAM; Java sử dụng **stack** để lưu vị trí, trong khi **heap** được dùng để lưu giá trị. Ngoài ra, có thể bạn sẽ thắc mắc: "Nếu ta dùng kiểu dữ liệu cơ bản (primitive type) để lưu giá trị bên trong một hàm thuộc lớp, liệu nó có được lưu ở heap cùng với giá trị của các đối tượng lớp khác không?" Câu trả lời là **KHÔNG**. Heap có dung lượng lớn hơn stack và thường được dùng để lưu trữ lượng lớn dữ liệu của các đối tượng lớp; do đó, để truy cập một giá trị trong heap, ta cần tham chiếu đến vị trí của nó được lưu trong stack rồi mới tìm thấy giá trị đó tại heap. Tóm lại, để tối ưu hóa chương trình, Java sử dụng heap để lưu các biến toàn cục hoặc biến thành viên của lớp (class variables), còn stack được dùng để lưu vị trí cũng như các biến cục bộ hoặc biến tạm thời bên trong hàm của lớp. Dưới đây là ví dụ minh họa:
>```java
>public class MemoryDemo {
>    
>    // TRƯỜNG HỢP 1: BIẾN NẰM TRÊN HEAP
>    // Tuy là kiểu int, nhưng nó là thuộc tính của Class (Instance variable)
>    // Khi tạo đối tượng, 'id' sẽ nằm TRÊN HEAP cùng với đối tượng đó.
>    int id = 999; 
>
>    public void testMethod(int param) { // TRƯỜNG HỢP 2: NẰM TRÊN STACK
>                                        // 'param' là tham số của hàm, nằm trên Stack
>        
>        // TRƯỜNG HỢP 3: NẰM TRÊN STACK
>        // 'age' là kiểu nguyên thủy, khai báo TRONG HÀM -> Nằm hoàn toàn trên Stack
>        int age = 20; 
>        
>        // TRƯỜNG HỢP 4: CHỈ CÓ BIẾN THAM CHIẾU NẰM TRÊN STACK
>        // Biến 'str' nằm trên Stack, nhưng chuỗi "Hello" thực tế nằm ở Heap
>        String str = "Hello"; 
>    }
>}
>```
## Wrapper Class
### What is wrapper class ? (lớp wrapper class là gì ?)
Basically it just convert the variable of a primitive datatype to a object, here is the convert board:
| Primitive | Wrapper |
| :---: | :---: |
| int | Integer |
| char | Character |
| double | Double |
| boolean | Boolean |
| float, long, short, byte, ... | Float, Long, Short, Byte, ... |
>Đơn giản là chuyển đổi biến có kiểu dữ liệu nguyên thủy (primitive) thành đối tượng (object); dưới đây là bảng chuyển đổi:
>| Kiểu nguyên thủy | lớp Wrapper |
>| :---: | :---: |
>| int | Integer |
>| char | Character |
>| double | Double |
>| boolean | Boolean |
>| float, long, short, byte, ... | Float, Long, Short, Byte, ... |
### Autoboxing
Autoboxing is the process that automatically convert from primitive to the related wrapper class. This process is executed by java in backend, which will help the developer to save their time.
>Autoboxing là quá trình tự động chuyển đổi từ kiểu dữ liệu nguyên thủy (primitive) sang lớp bao (wrapper class) tương ứng. Quá trình này được Java thực hiện ở phía sau (backend), giúp lập trình viên tiết kiệm thời gian.
### Unboxing
Its ability is opposite with the autoboxing (same thing but opposite)
>Chức năng của nó ngược lại với cơ chế autoboxing (cùng bản chất nhưng theo chiều ngược lại).