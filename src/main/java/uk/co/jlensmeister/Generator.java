package uk.co.jlensmeister;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by dthaler on 27/06/2017.
 */
public class Generator {

    public static void main(String[] args){

        if(args.length == 0){
            System.out.print("Missing folder name");
            System.exit(1);
        }

        String folderName = args[0];
        File folder = new File(folderName);

        if(!folder.exists()){
            System.out.print("No such folder");
            System.exit(1);
        }

        if(folder.isFile()){
            System.out.print("This is a file");
            System.exit(1);
        }

        File outputFolder = new File("Windows 10\\" + folderName);
        File outputFile = new File("Windows 10\\" + folderName + "\\" + folderName +".xml");
        if(outputFolder.exists()){
            if(outputFile.exists()){
                outputFile.delete();
            }else{
                try {
                    outputFile.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }else{
            outputFolder.mkdirs();
            try {
                outputFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            FileWriter fw = new FileWriter(outputFile);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write("<LayoutModificationTemplate xmlns:defaultlayout=\"http://schemas.microsoft.com/Start/2014/FullDefaultLayout\" xmlns:start=\"http://schemas.microsoft.com/Start/2014/StartLayout\" Version=\"1\" xmlns=\"http://schemas.microsoft.com/Start/2014/LayoutModification\">");
            bw.newLine();
            bw.write("  <LayoutOptions StartTileGroupCellWidth=\"6\" />");
            bw.newLine();
            bw.write("  <DefaultLayoutOverride>");
            bw.newLine();
            bw.write("    <StartLayoutCollection>");
            bw.newLine();
            bw.write("      <defaultlayout:StartLayout GroupCellWidth=\"6\">");
            bw.newLine();

            File topLeft = new File(folderName + "\\SCRIPT-TopLeftGroup");
            bw.write("        <start:Group Name=\"\">");
            bw.newLine();

            int c = 0;
            int r = 0;
            for(File f : topLeft.listFiles()){
                if(f.isHidden()){

                }else {
                    bw.write("          <start:DesktopApplicationTile Size=\"2x2\" Column=\"" + c + "\" Row=\"" + r + "\" DesktopApplicationLinkPath=\"%SystemDrive%\\Sjc\\StartMenus\\" + folderName + "10\\SCRIPT-TopLeftGroup\\" + f.getName() + "\" />");
                    bw.newLine();
                    if (c != 4) {
                        c += 2;
                    } else {
                        c = 0;
                        r += 2;
                    }
                }
            }

            bw.write("        </start:Group>");
            bw.newLine();

            File topRight = new File(folderName + "\\SCRIPT-TopRightGroup");
            bw.write("        <start:Group Name=\"\">");
            bw.newLine();

            c = 0;
            r = 0;
            for(File f : topRight.listFiles()){
                if(f.isHidden()){

                }else {
                    bw.write("          <start:DesktopApplicationTile Size=\"2x2\" Column=\"" + c + "\" Row=\"" + r + "\" DesktopApplicationLinkPath=\"%SystemDrive%\\Sjc\\StartMenus\\" + folderName + "10\\SCRIPT-TopRightGroup\\" + f.getName() + "\" />");
                    bw.newLine();
                    if (c != 4) {
                        c += 2;
                    } else {
                        c = 0;
                        r += 2;
                    }
                }
            }

            bw.write("        </start:Group>");
            bw.newLine();


            for(File f : folder.listFiles()){

                if(f.getName().equalsIgnoreCase("SCRIPT-TopLeftGroup")){

                }else if(f.getName().equalsIgnoreCase("SCRIPT-TopRightGroup")){

                }else if(f.isFile()){

                }else{

                    bw.write("        <start:Group Name=\"" + f.getName() + "\">");
                    bw.newLine();
                    bw.write("          <start:Folder Size=\"4x2\" Column=\"0\" Row=\"0\">");
                    bw.newLine();

                    c = 0;
                    r = 0;
                    for(File f2 : f.listFiles()){
                        if(f2.isHidden()){

                        }else {
                            bw.write("            <start:DesktopApplicationTile Size=\"2x2\" Column=\"" + c + "\" Row=\"" + r + "\" DesktopApplicationLinkPath=\"%SystemDrive%\\Sjc\\StartMenus\\" + folderName + "10\\" + f.getName() + "\\" + f2.getName() + "\" />");
                            bw.newLine();
                            if (c != 4) {
                                c += 2;
                            } else {
                                c = 0;
                                r += 2;
                            }
                        }
                    }


                    bw.write("          </start:Folder>");
                    bw.newLine();
                    bw.write("        </start:Group>");
                    bw.newLine();

                }

            }


            bw.write("      </defaultlayout:StartLayout>");
            bw.newLine();
            bw.write("    </StartLayoutCollection>");
            bw.newLine();
            bw.write("  </DefaultLayoutOverride>");
            bw.newLine();
            bw.write("</LayoutModificationTemplate>");
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
