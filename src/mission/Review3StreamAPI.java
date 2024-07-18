/* 미션
 * 
 * 1. 소스 분석하기
 * 2. 다양한 사용법 익히기
 */

package mission;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

public class Review3StreamAPI {
	
	//step01 - printf() / %s / %d 학습
	//하나의 문자열을 %s 표기에는 String 데이터, %d 표기는 숫자 타입의 변수 데이터 적용하는 기술
//	@Test
	public void step01() {
		String data = "fisa";
		int age = 2;
		System.out.println("2024년 " + data + " " + age);
		System.out.printf("2024년 %s %d", data, age);
	}
	
	
	@Test
	//step02 - 소스 보고 분석하세요
	public void step02(){
		List<String> strList = Arrays.asList("abc", "", "bcd", "", "defg", "jk");
		
		System.out.println("-- 1 --");
		long count = strList.stream().filter(x -> x.isEmpty()).count();
		/* String타입 데이터가 들어있는 strList 에서
		 * stream() 을 통해 데이터들을 순차적으로 가져오고
		 * filter를 이용해서 x.isEmpty()인 데이터들을
		 * .count()로 개수를 세어서 
		 * long 타입 count()에 저장
		 */
		System.out.printf("리스트의 모든 문자열 :  %s, 빈문자열 개수 : %d개", strList, count);
		/* %s 는 string %d 는 decimal System.out.printf(---%s ---- %d, %s 에 해당하는 string 형 데이터 , %d 에 해당하는 정수형 데이터?)
		 * 
		 */
		
		System.out.println("\n-- 2 --");
		long num = strList.stream().filter(x -> x.length() > 3).count();
		/* String 데이터가 들어있는 strList 에서
		 * stream() 을 통해 데이터들을 순차적으로 가져오고
		 * filter() 로 x.length() > 3 인 데이터들을 골라내고
		 * count()로 개수를 세어서 
		 * long 타입 num 에 저장
		 */
		System.out.printf("리스트의 문자열 길이가 3이상인 문자열 개수 :  %s, %d개", strList, num);
		
		System.out.println("\n-- 3 --");
		count = strList.stream().filter(x -> x.startsWith("a")).count();
		/* //
		 * filter 를 통해서
		 * 문자열이 "a"로 시작하는 값을을 찾고
		 * count() 로 개수를 세어서 저장
		 */
		System.out.printf("리스트에서 a로 시작하는 문자들 :  %s,  %d개", strList, count);
			
		
		
		System.out.println("\n-- 4 --");
		List<String> filtered = strList.stream().filter(x -> !x.isEmpty()).collect(Collectors.toList());
		/* strList 를 가져와서 stream() 으로 값들을 순차적으로 가져오고
		 * filter(x -> !x.isEmpty()) 로 값이 비어있지 않은 것들을 추출해서
		 * collect(Collectors.toList()) 로 요소들을 list 로 반환
		 */
		System.out.printf("모든 리스트 데이터 : %s, 빈문자열이 없는 리스트 : %s", strList, filtered);
		
		System.out.println("\n-- 5 --");
		
		filtered = strList.stream().filter(x -> x.length() > 2).collect(Collectors.toList());
		System.out.printf("모든 리스트 데이터 : %s, 문자열 길이가 2를 초과한 문자열 : %s", strList, filtered);
		
		List<String> countryName = Arrays.asList("Korea", "USA", "France", "Germany", "Italy", "U.K.", "Canada");

		System.out.println("\n-- 6 --");
		String country = countryName.stream().map(x -> x.toUpperCase()).collect(Collectors.joining(", "));
		/* map 은 스트링의 각 요소에 대해 람다식을 적용하여 새로운 요소로 변경하는 역할
		 * filter 는 주어진 조건에 맞는 요소만 추출하는 역할
		 * toUpperCase()는 각 요소의 문자열을 대문자로 바꾸는 메소드
		 * collect(Collectors.joining(", ")) 은 map 을 통해 바뀐 요소들을 "," 로 구분하여 문자열로 결합하는 메소드
		 * 
		 */
		System.out.println("모든 나라 이름이 대문자로 변환된 데이터 " + country);
		
		countryName = countryName.stream().map(x -> x.toUpperCase()).collect(Collectors.toList());
		/* 위와 똑같이 각 요소를 대문자로 변환하고 list 로 반환
		 * 
		 */
		System.out.println("모든 나라 이름이 대문자로 변환된 데이터 " + countryName);

		
		List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
		
		System.out.println("\n-- 7 --");
		List<Integer> distinct = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
		/* numbers list 에서 stream()으로 값을 순차적으로 가져오고 map 으로 각 요소를 제곱하여 distinct() 로 중복된 값을 제거하고 리스트로 반환
		 * 
		 */
		System.out.printf("모든 데이터 : %s, 곱한 연산 결과값들 중복 제거된 데이터 : %s", numbers, distinct);
		
		List<Integer> data = numbers.stream().map(i -> i*i).collect(Collectors.toList());
		System.out.printf("\n--- distince() 없이 %s - %s %n", numbers, data);
		
		
		System.out.println("\n-- 8 : 기초 통계 --");
		List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
		IntSummaryStatistics stats = primes.stream().mapToInt(x -> x).summaryStatistics();
		/* stream() 으로 데이터를 순차적으로 가져오고 
		 * mapToInt(x -> x)로 각 요소를 int 형으로 가져오고
		 * summaryStatistics() 를 이용해 각 요소들에 대한 min, max, sum, average, count 등의 정보를 반환
		 * 
		 */
		System.out.println(stats); 
		System.out.println("목록에서 가장 높은 소수 : " + stats.getMax());
		System.out.println("목록에서 가장 작은 소수 : " + stats.getMin());
		System.out.println("모든 수의 합 : " + stats.getSum());
		System.out.println("모든 수의 평균 : " + stats.getAverage());
		
	}

}
