

def bge(a, b, imm, p=True):
    code = 0x30
    op = 0b11000
    a = str(bin(a))
    b = str(bin(b))
    imm = str(bin(imm))


    return code