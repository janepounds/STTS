package com.example.seedtrackingtracing;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

public class ProfileDetails extends AppCompatActivity {
    private DatabaseReference databaseReference;
    private TextView profileNameTextView, profileSurnameTextView, profilePhonenoTextView, profileVillage, profileDistrict;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;
    private ImageView profilePicImageView;
    private FirebaseStorage firebaseStorage;
    private TextView textViewemailname;
    private EditText editTextfName;
    private FirebaseFirestore db;
    private String TAG="Profile Details";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_details);
        getSupportActionBar().hide();
        db = FirebaseFirestore.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();
        editTextfName = (EditText) findViewById(R.id.et_username);
        profilePicImageView = findViewById(R.id.profile_pic_imageView);
        profileNameTextView = findViewById(R.id.profile_name_textView);
        profileSurnameTextView = findViewById(R.id.profile_surname_textView);
        profilePhonenoTextView = findViewById(R.id.profile_phoneno_textView);
        profileVillage = (TextView) findViewById(R.id.profile_village_textView);
        profileDistrict = (TextView) findViewById(R.id.profile_district_textView);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseStorage = FirebaseStorage.getInstance();
        // DatabaseReference databaseReference = firebaseDatabase.getReference(firebaseAuth.getUid());
        StorageReference storageReference = firebaseStorage.getReference();
        // Get the image stored on Firebase via "User id/Images/Profile Pic.jpg".
//        storageReference.child(firebaseAuth.getUid()).child("Images").child("Profile Pic").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
//            @Override
//            public void onSuccess(Uri uri) {
//                // Using "Picasso" (http://square.github.io/picasso/) after adding the dependency in the Gradle.
//                // ".fit().centerInside()" fits the entire image into the specified area.
//                // Finally, add "READ" and "WRITE" external storage permissions in the Manifest.
//                Picasso.get().load(uri).fit().centerInside().into(profilePicImageView);
//            }
//        });
//        if (firebaseAuth.getCurrentUser() == null) {
//            finish();
//            startActivity(new Intent(getApplicationContext(), SignInActivity.class));
//        }
        final FirebaseUser user = firebaseAuth.getCurrentUser();
//        final DocumentReference docRef = db.collection(user.getUid()).document("Profiles");

//        final ListenerRegistration listenerRegistration = docRef.addSnapshotListener(new EventListener<DocumentSnapshot>() {
//            @Override
//            public void onEvent(@Nullable DocumentSnapshot snapshot,
//                                @Nullable FirebaseFirestoreException e) {
//                if (e != null) {
//                    Log.w(TAG, "Listen failed.", e);
//                    return;
//                }
//
//                if (snapshot != null && snapshot.exists()) {
//                    Log.d(TAG, "Current data: " + snapshot.getData());
//                    UserInfo userProfile = snapshot.toObject(UserInfo.class);
//                    profileNameTextView.setText(userProfile.firstName);
//                    profileSurnameTextView.setText(userProfile.lastName);
//                    profilePhonenoTextView.setText(userProfile.phoneNumber);
//                    profileDistrict.setText(userProfile.district);
//                    profileVillage.setText(userProfile.village);
//                    textViewemailname = (TextView) findViewById(R.id.textViewEmailAdress);
//                    textViewemailname.setText(user.getEmail());
//                } else {
//                    Log.d(TAG, "Current data: null");
//                }
//            }
//        });
    }

    public void buttonClickedEditName(View view) {
        LayoutInflater inflater = getLayoutInflater();
        View alertLayout = inflater.inflate(R.layout.layout_custom_dialog_edit_name, null);
        final EditText etUsername = alertLayout.findViewById(R.id.et_username);
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Name Edit");
        // this is set the view from XML inside AlertDialog
        alert.setView(alertLayout);
        // disallow cancel of AlertDialog on click of back button and outside touch
        alert.setCancelable(false);
        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String name = etUsername.getText().toString();
                String surname = profileSurnameTextView.getText().toString();
                String phoneno = profilePhonenoTextView.getText().toString();
                String district = profileDistrict.getText().toString();
                String village = profileVillage.getText().toString();
                UserInfo userinformation = new UserInfo(name, surname, phoneno, district, village);
                FirebaseUser user = firebaseAuth.getCurrentUser();
                db.collection(user.getUid()).document("Profiles").set(userinformation);

                etUsername.onEditorAction(EditorInfo.IME_ACTION_DONE);
            }
        });
        AlertDialog dialog = alert.create();
        dialog.show();
    }

    public void buttonClickedEditSurname(View view) {
        LayoutInflater inflater = getLayoutInflater();
        View alertLayout = inflater.inflate(R.layout.layout_custom_dialog_edit_last_name, null);
        final EditText etUserSurname = alertLayout.findViewById(R.id.et_last_name);
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Last Name Edit");
        // this is set the view from XML inside AlertDialog
        alert.setView(alertLayout);
        // disallow cancel of AlertDialog on click of back button and outside touch
        alert.setCancelable(false);
        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                String name = profileNameTextView.getText().toString();
                String surname = etUserSurname.getText().toString();
                String phoneno = profilePhonenoTextView.getText().toString();
                String district = profileDistrict.getText().toString();
                String village = profileVillage.getText().toString();
                UserInfo userinformation = new UserInfo(name, surname, phoneno, district, village);
                FirebaseUser user = firebaseAuth.getCurrentUser();
                db.collection(user.getUid()).document("Profiles").set(userinformation);
                etUserSurname.onEditorAction(EditorInfo.IME_ACTION_DONE);
            }
        });
        AlertDialog dialog = alert.create();
        dialog.show();
    }

    public void buttonClickedEditPhoneNo(View view) {
        LayoutInflater inflater = getLayoutInflater();
        View alertLayout = inflater.inflate(R.layout.layout_custom_dialog_edit_phoneno, null);
        final EditText etUserPhoneno = alertLayout.findViewById(R.id.et_userPhoneno);
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Phone No Edit");
        // this is set the view from XML inside AlertDialog
        alert.setView(alertLayout);
        // disallow cancel of AlertDialog on click of back button and outside touch
        alert.setCancelable(false);
        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String name = profileNameTextView.getText().toString();
                String surname = profileSurnameTextView.getText().toString();
                String phoneno = etUserPhoneno.getText().toString();
                String district = profileDistrict.getText().toString();
                String village = profileVillage.getText().toString();
                UserInfo userinformation = new UserInfo(name, surname, phoneno, district, village);
                FirebaseUser user = firebaseAuth.getCurrentUser();
                db.collection(user.getUid()).document("Profiles").set(userinformation);
                etUserPhoneno.onEditorAction(EditorInfo.IME_ACTION_DONE);
            }
        });
        AlertDialog dialog = alert.create();
        dialog.show();
    }

    public void buttonClickedEditDistrict(View view) {
        LayoutInflater inflater = getLayoutInflater();
        View alertLayout = inflater.inflate(R.layout.layout_custom_dialog_edit_district, null);
        final EditText etDistrict = alertLayout.findViewById(R.id.et_district);
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("District Edit");
        // this is set the view from XML inside AlertDialog
        alert.setView(alertLayout);
        // disallow cancel of AlertDialog on click of back button and outside touch
        alert.setCancelable(false);
        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String name = profileNameTextView.getText().toString();
                String surname = profileSurnameTextView.getText().toString();
                String phoneno = profilePhonenoTextView.getText().toString();
                String district = etDistrict.getText().toString();
                String village = profileVillage.getText().toString();
                UserInfo userinformation = new UserInfo(name, surname, phoneno, district, village);
                FirebaseUser user = firebaseAuth.getCurrentUser();
                db.collection(user.getUid()).document("Profiles").set(userinformation);
                etDistrict.onEditorAction(EditorInfo.IME_ACTION_DONE);
            }
        });
        AlertDialog dialog = alert.create();
        dialog.show();
    }

    public void buttonClickedEditVillage(View view) {
        LayoutInflater inflater = getLayoutInflater();
        View alertLayout = inflater.inflate(R.layout.layout_custom_dialog_edit_village, null);
        final EditText et_village = alertLayout.findViewById(R.id.et_village);
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Village Edit");
        // this is set the view from XML inside AlertDialog
        alert.setView(alertLayout);
        // disallow cancel of AlertDialog on click of back button and outside touch
        alert.setCancelable(false);
        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String name = profileNameTextView.getText().toString();
                String surname = profileSurnameTextView.getText().toString();
                String phoneno = profilePhonenoTextView.getText().toString();
                String district = profileDistrict.getText().toString();
                String village = et_village.getText().toString();
                UserInfo userinformation = new UserInfo(name, surname, phoneno, district, village);
                FirebaseUser user = firebaseAuth.getCurrentUser();
                db.collection(user.getUid()).document("Profiles").set(userinformation);
                et_village.onEditorAction(EditorInfo.IME_ACTION_DONE);
            }
        });
        AlertDialog dialog = alert.create();
        dialog.show();
    }

    public void navigateLogOut(View v) {
        FirebaseAuth.getInstance().signOut();
        Intent inent = new Intent(this, SignInActivity.class);
        startActivity(inent);
    }
    public void changePassword(View v) {
        Intent inent = new Intent(this, ResetPasswordActivity.class);
        startActivity(inent);
    }

    @Override
    public void onBackPressed() {

        Intent intent = new Intent(ProfileDetails.this,MainActivity.class);
        startActivity(intent);
    }
}
