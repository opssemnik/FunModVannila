package FunMod.blocks;

import net.minecraft.src.Block;
import net.minecraft.src.Material;

public class BlockQuestionBlock extends Block
{
        public BlockQuestionBlock(int i, int j)
        {
                super(i, j , Material.rock);
                this.blockIndexInTexture = 1;
                this.setCreativeTab(FunMod.FunMod.funmodtab);
        }

        public int getBlockTextureFromSideAndMetadata (int i, int j)
        {

            

            if (i == 0)

                    

                    return 2;

            if (i == 1)

                    

                    return 2;

            

            if (i == 2)

                    

                    return 1;

    if (i == 3)

                    

                    return 1;

    if (i == 4)

            

            return 1;

    if (i == 5)

            

            return 1;

       

        if (j ==1)

        {

            return 166;

        }

        

        return j != 2 ? 20 : 177;

        } 
public String getTextureFile(){       
return "/FunMod/cliente/texturas/texturas.png";}
}