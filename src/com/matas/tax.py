# coding:utf-8
salary = 30000  # 应发工资
freeLine = 5000  # 每月减免【固定】
insurance = 1400  # 三险一金【公积金+医保】
children = 0  # 子女
oldman = 0  # 老人
rent = 0  # 租房
loans = 1000  # 房贷
month = 12  # 第几个月
totalTax = 0  # 累计预扣预缴税

for i in range(1, month+1):
    sum_tax = (salary - freeLine - insurance - children - oldman - rent - loans) * i  # 累计预扣预缴应纳税所得额
    fast = 0  # 速算扣除数
    rate = 0.03  # 预扣率

    if sum_tax <= 36000:
        rate = 0.03
        fast = 0
    elif 36000 < sum_tax <= 144000:
        rate = 0.1
        fast = 2520
    elif 144000 < sum_tax <= 300000:
        rate = 0.2
        fast = 16920
    elif 300000 < sum_tax <= 420000:
        rate = 0.25
        fast = 31920
    elif 420000 < sum_tax <= 660000:
        rate = 0.3
        fast = 52920
    elif 660000 < sum_tax <= 960000:
        rate = 0.35
        fast = 85920
    elif sum_tax > 960000:
        rate = 0.45
        fast = 181920

    preTax = sum_tax * rate - fast - totalTax
    totalTax += preTax
    daoshou = salary - preTax - insurance
    print("第%d个月应预扣预缴税=>%.2f到手工资=>%.2f，到目前共预缴税=>%.2f" % (i, preTax, daoshou, totalTax))
