#SIKOBE IAN WALTER-P15/42815/2017
#YEAR 3 GROUP 2
#DECISION TREE ALGORITHM IN MACHINE LEARNING FOR DATA
import math


# Function for staring process of tree generation
def make_tree(data, treeit):
    len_yes = len([row for row in data if 'yes' in row[4]])

    len_no = len([row for row in data if 'no' in row[4]])

    data_length = len(data)

    # find classification entropy
    entropy = ((-len_yes / data_length) * math.log2(len_yes / data_length)) - (
                (len_no / data_length) * math.log2(len_no / data_length))
    info_gain(data, len_yes, len_no, entropy, data_length, treeit)


# function for finding information gain of each attribute
def info_gain(data, len_yes, len_no, entropy, data_length, treeit):
    # Find information gain of Engine
    len_small = len([row for row in data if 'small' in row[0]])
    len_med = len([row for row in data if 'medium' in row[0]])
    len_large = len([row for row in data if 'large' in row[0]])

    len_syes = len([row for row in data if 'small' in row[0] and "yes" in row[4]])
    len_sno = len([row for row in data if 'small' in row[0] and "no" in row[4]])
    len_myes = len([row for row in data if 'medium' in row[0] and "yes" in row[4]])
    len_mno = len([row for row in data if 'medium' in row[0] and "no" in row[4]])
    len_lyes = len([row for row in data if 'large' in row[0] and "yes" in row[4]])
    len_lno = len([row for row in data if 'large' in row[0] and "no" in row[4]])
    entropy = 0.971
    Ismall = 0.0
    Imedium = 0.0
    Ilarge = 0.0
    if len_syes and len_sno != 0:
        Ismall = ((-len_syes / len_small) * math.log2(len_syes / len_small)) - (
                    (len_sno / len_small) * math.log2(len_sno / len_small))
    if len_myes and len_mno != 0:
        Imedium = ((-len_myes / len_med) * math.log2(len_myes / len_med)) - (
                    (len_mno / len_med) * math.log2(len_mno / len_med))
    if len_lyes and len_lno != 0:
        Ilarge = ((-len_lyes / len_large) * math.log2(len_lyes / len_large)) - (
                    (len_lno / len_large) * math.log2(len_lno / len_large))

    # Information gain of Engine
    Ig_Eng = entropy - ((Ismall * (len_small / data_length)) + (Ilarge * (len_large / data_length)) + (
                Imedium * (len_med / data_length)))

    # Find information gain of SC Turbo
    len_tyes = len([row for row in data if 'yes' in row[1]])
    len_tno = len([row for row in data if 'no' in row[1]])

    len_tyyes = len([row for row in data if 'yes' in row[1] and "yes" in row[4]])
    len_tyno = len([row for row in data if 'yes' in row[1] and "no" in row[4]])
    len_tnyes = len([row for row in data if 'no' in row[1] and "yes" in row[4]])
    len_tnno = len([row for row in data if 'no' in row[1] and "no" in row[4]])

    Iyes = 0.0
    Ino = 0.0
    if len_tyyes and len_tyno != 0:
        Iyes = ((-len_tyyes / len_tyes) * math.log2(len_tyyes / len_tyes)) - (
                    (len_tyno / len_tyes) * math.log2(len_tyno / len_tyes))

    if len_tnyes and len_tnno != 0:
        Ino = ((-len_tnyes / len_tno) * math.log2(len_tnyes / len_tno)) - (
                    (len_tnno / len_tno) * math.log2(len_tnno / len_tno))

    # Information gain of Sc Turbo
    Ig_tur = entropy - ((Iyes * (len_tyes / data_length)) + (Ino * (len_tno / data_length)))

    # Find information gain of Weight
    len_light = len([row for row in data if 'light' in row[2]])
    len_avg = len([row for row in data if 'average' in row[2]])
    len_heavy = len([row for row in data if 'heavy' in row[2]])

    len_liyes = len([row for row in data if 'light' in row[2] and "yes" in row[4]])
    len_lino = len([row for row in data if 'light' in row[2] and "no" in row[4]])
    len_ayes = len([row for row in data if 'average' in row[2] and "yes" in row[4]])
    len_ano = len([row for row in data if 'average' in row[2] and "no" in row[4]])
    len_hyes = len([row for row in data if 'heavy' in row[2] and "yes" in row[4]])
    len_hno = len([row for row in data if 'heavy' in row[2] and "no" in row[4]])

    Ilight = 0.0
    Iavg = 0.0
    Iheavy = 0.0

    if len_liyes and len_lino != 0:
        Ilight = ((-len_liyes / len_light) * math.log2(len_liyes / len_light)) - (
                    (len_lino / len_light) * math.log2(len_lino / len_light))
    if len_ayes and len_ano != 0:
        Iavg = ((-len_ayes / len_avg) * math.log2(len_ayes / len_avg)) - (
                    (len_ano / len_avg) * math.log2(len_ano / len_avg))
    if len_hyes and len_hno != 0:
        Iheavy = ((-len_hyes / len_heavy) * math.log2(len_hyes / len_heavy)) - (
                    (len_hno / len_heavy) * math.log2(len_hno / len_heavy))

    # Information gain of weight
    Ig_Wgt = entropy - ((Ilight * (len_light / data_length)) + (Iheavy * (len_heavy / data_length)) + (
                Iavg * (len_avg / data_length)))

    # Find information gain of fuel
    len_gd = len([row for row in data if 'good' in row[3]])
    len_avg1 = len([row for row in data if 'average' in row[3]])
    len_bad = len([row for row in data if 'bad' in row[3]])

    len_gyes = len([row for row in data if 'good' in row[3] and "yes" in row[4]])
    len_gno = len([row for row in data if 'good' in row[3] and "no" in row[4]])
    len_avyes = len([row for row in data if 'average' in row[3] and "yes" in row[4]])
    len_avno = len([row for row in data if 'average' in row[3] and "no" in row[4]])
    len_byes = len([row for row in data if 'bad' in row[3] and "yes" in row[4]])
    len_bno = len([row for row in data if 'bad' in row[3] and "no" in row[4]])

    Igd = 0.0
    Iavg1 = 0.0
    if len_gyes and len_gno != 0:
        Igd = ((-len_gyes / len_gd) * math.log2(len_gyes / len_gd)) - ((len_gno / len_gd) * math.log2(len_gno / len_gd))
    if len_avyes and len_avno != 0:
        Iavg1 = ((-len_avyes / len_avg1) * math.log2(len_avyes / len_avg1)) - (
                    (len_avno / len_avg1) * math.log2(len_avno / len_avg1))
    if len_byes and len_bno != 0:
        Ibad = ((-len_byes / len_bad) * math.log2(len_byes / len_bad)) - (
                    (len_bno / len_bad) * math.log2(len_bno / len_bad))

    # information gain of fuel
    Ig_fuel = entropy - (
                (Igd * (len_gd / data_length)) + (Iavg1 * (len_avg1 / data_length)) + (Ibad * (len_bad / data_length)))

    # Find the node with the highest information gain
    node = max(Ig_Eng, Ig_fuel, Ig_tur, Ig_Wgt)

    dec_tree(node, data, Ig_Eng, Ig_fuel, Ig_tur, Ig_Wgt, treeit)


# function for  creating nodes for decision tree
def dec_tree(node, data, Ig_Eng, Ig_fuel, Ig_tur, Ig_Wgt, treeit):
    # declare the information gains of each attributes with their properties in attrid array
    attrid = [[Ig_Eng, 0, 'Engine'], [Ig_tur, 1, 'Sc Turbo'], [Ig_Wgt, 2, 'Weight'], [Ig_fuel, 3, 'Fuel Economy']]

    # function for finding the root node and the position of node data in main data array
    for row in attrid:
        for column in row:
            if column == node:
                attrcol = row[1]
                print(row[2], ":{")
                attrid.remove(row)

    # function for getting a list of attributes of the most dominant node
    attrna = []
    for aList1 in data:
        for aList2 in aList1:
            if aList1[attrcol] not in attrna:
                attrna.append(aList1[attrcol])

    counter = 0
    # function for splitting data and also finding the nodes
    while counter < len(attrna):
        subdat = [row for row in data if attrna[counter] in row[attrcol]]
        trial = 2
        # print(attrna[counter])

        if len([row for row in subdat if 'yes' in row[4]]) == len(subdat):
            print(attrna[counter], ': yes')
        elif len([row for row in subdat if 'no' in row[4]]) == len(subdat):
            print(attrna[counter], ': no')
        # elif len([row for row in data if 'no' or 'yes'in row[4]]) == 2:
        #     print('yes and no')
        else:
            # call function think tree
            think_tree(subdat, treeit, attrna[counter])

        counter = counter + 1
    print("}")


# conditional function for recursion
def think_tree(subdat, treeit, attrna):
    if treeit < 2:
        treeit = treeit + 1
        print(attrna, ":")
        make_tree(subdat, treeit)


# dataset

data = [['small', 'no', 'average', 'good', 'no'],
        ['small', 'no', 'light', 'average', 'no'],
        ['small', 'yes', 'average', 'bad', 'yes'],
        ['medium', 'no', 'heavy', 'bad', 'yes'],
        ['large', 'no', 'average', 'bad', 'yes'],
        ['medium', 'no', 'light', 'bad', 'no'],
        ['large', 'yes', 'heavy', 'bad', 'no'],
        ['large', 'no', 'heavy', 'bad', 'no'],
        ['medium', 'yes', 'light', 'bad', 'yes'],
        ['large', 'no', 'average', 'bad', 'yes'],
        ['small', 'no', 'light', 'good', 'no'],
        ['small', 'no', 'average', 'average', 'no'],
        ['medium', 'no', 'heavy', 'bad', 'no'],
        ['small', 'yes', 'average', 'average', 'no'],
        ['medium', 'no', 'heavy', 'bad', 'no']]

# variable for stopping condition in recursion
treeit = 0
# function for making a tree
make_tree(data, treeit)
