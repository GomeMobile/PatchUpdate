package org.hyxf.patch;

import java.io.File;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import org.hyxf.bsdiff.PatchTools;
import org.hyxf.patch.R;

@SuppressLint("SdCardPath")
public class MainActivity extends Activity implements OnClickListener {

	private String mSdCartPath = Environment.getExternalStorageDirectory()
			.getAbsolutePath();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		findViewById(R.id.button1).setOnClickListener(this);
		findViewById(R.id.button2).setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.getId() == R.id.button1){
			PatchTools.bspatch(mSdCartPath + "/patchss/GomeEShop3.apk",
					mSdCartPath + "/patchss/GomeEShop.apk", mSdCartPath
					+ "/patchss/GomeEShop.patch");
			String fileName = mSdCartPath + "/patchss/GomeEShop.apk";
			
			Intent intent = new Intent(Intent.ACTION_VIEW);
			intent.setDataAndType(Uri.fromFile(new File(fileName)),
					"application/vnd.android.package-archive");
			startActivity(intent);
		}else if(v.getId() == R.id.button2){
			File f = new File(mSdCartPath + "/patchss/GomeEShop.apk");
			if(f.exists()){
				f.delete();
				Toast.makeText(this, "清空成功", Toast.LENGTH_SHORT).show();
			}else{
				Toast.makeText(this, "不存在", Toast.LENGTH_SHORT).show();
			}
		}
	}

}
