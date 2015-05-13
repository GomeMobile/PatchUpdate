package org.hyxf.bsdiff;

public class PatchTools {

	static{
		System.loadLibrary("patchtools");
	}
	
	public native static int bspatch(String oldPackage,String newPack,String patch);
	
}
