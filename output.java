{// block number 1
    public static void main(String[] args) 
{// block number 2
        int year = 2022;
        boolean leap = false;
        if (year % 4 == 0) 
{// block number 3
            if (year % 100 == 0) 
{// block number 4
                if (year % 400 == 0) 
{// block number 5
                    leap = true;
                }
                else
{// block number 6
                    leap = false;
                }
            }
            else
{// block number 7
                leap = false;
            }
        }
        else
{// block number 8
            leap = false;
        }
        if (leap)
{// block number 9
            System.out.println(year + " is a leap year.");
        }
        else
{// block number 10
            System.out.println(year + " is not a leap year.");
        }
        return;
    }
}
