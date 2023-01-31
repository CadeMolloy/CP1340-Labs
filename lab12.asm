.begin
        IN x
        IN y
while:  LOAD y
        COMPARE i
        JUMPGT done
        LOAD p
        ADD x
        STORE p
        INCREMENT i
        JUMP while
done:   OUT p
        HALT
x:      .data 0
y:      .data 0
i:      .data 1
p:      .data 0
.end 