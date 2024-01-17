class Solution {
            static class Service implements Comparable<Service>{
                int num;
                int price;

                public Service(int num, int price) {
                    this.num = num;
                    this.price = price;
                }

                public int getNum() {
                    return num;
                }

                public void setNum(int num) {
                    this.num = num;
                }

                public int getPrice() {
                    return price;
                }

                public void setPrice(int price) {
                    this.price = price;
                }

                @Override
                public int compareTo(Service o){
                    return this.num==o.num ? this.price-o.price : this.num-o.num;
                }
            }
            public  static int[] solution(int[][] users, int[] emoticons){
                int[] rate= {10,20,30,40};
                int[] arr= new int[emoㄱticons.length];
                List<Service> serviceList= new ArrayList<>();
                dfs(rate,emoticons,arr,users,serviceList,0);

                serviceList.sort(Comparator.reverseOrder());
                return new int[]{serviceList.get(0).getNum(),serviceList.get(0).getPrice()};
            }

            private static void dfs(int[] rate, int[] emoticons, int[] arr, int[][] users, List<Service> serviceList, int depth) {
                if (depth==emoticons.length)
                {
                    int price=0;
                    int num=0;
                    for (int[] user : users) {
                        int r=user[0];
                        int th=user[1];
                        int sum=0;
                        for (int i=0;i< arr.length;i++){
                            if(arr[i]>=r){
                                sum+=emoticons[i]*(1-((double)arr[i])/100);
                            }
                        }
                        if(sum>=th){
                            num++;
                        }else {
                            price+=sum;
                        }
                    }
                    serviceList.add(new Service(num,price));
                    return;
                }
                for (int i : rate) {
                    arr[depth]=i;
                    dfs(rate,emoticons,arr,users,serviceList,depth+1);
                }
            }

        }