//package java8;
//
//import com.google.common.collect.Lists;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.function.Supplier;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//public class StreamTest {
//
//
//    public static void main(String[] args) {
//        Stream.generate(StringObjectFactory::get);
//
//        List<Integer> nums = Lists.newArrayList(1,1,null,2,3,4,null,5,6,7,8,9,10);
//        List<Integer> numsWithoutNull = nums.stream().filter(num -> num != null).
//                collect(
//                        () -> new ArrayList<Integer>(),
//                        (list, item) -> list.add(item),
//                        (list1, list2) -> list1.addAll(list2));
//
//
//    }
//}
