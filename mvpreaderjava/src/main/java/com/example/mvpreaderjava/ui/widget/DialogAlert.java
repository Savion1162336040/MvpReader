package com.example.mvpreaderjava.ui.widget;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.mvpreaderjava.R;
import com.example.mvpreaderjava.ui.widget.imp.OnDialogCallBack;

/**
 * Created by Administrator on 2017-09-18.
 */
public class DialogAlert extends BaseDialogFragment implements DialogInterface.OnClickListener {
    public static String ARGS_TITLE = "args_title";
    public static String ARGS_MESSAGE = "args_message";
    public static String ARGS_CANCEL = "args_cancel";
    public static String ARGS_SURE = "args_sure";
    public static String ARGS_BTN_EXTRA = "args_btn_extra";
    public static String ARGS_ICON = "args_icon";
    public static String ARGS_FROM = "args_from";
    public static String ARGS_STATE = "state";


    public final static int STATE_FAILED = 0;
    public final static int STATE_SUCCESS = 1;
    public final static int STATE_LOADING = 2;
    public final static int STATE_DEFAULT = -1;


    public static final String FROM_ACTIVITY = "activity";
    public static final String FROM_DIALOGFRAGMENT = "dialogfragment";


    private String title;
    private String message;
    private String cancel;
    private String sure;
    private String extra;
    private int state = STATE_DEFAULT;
    private int icon;
    private OnDialogCallBack callBack;

    private TextView tvMsg;
    private ImageView ivIcon;
    private ProgressBar pbBar;

    @SuppressLint("ValidFragment")
    private DialogAlert() {
    }

    public void setCallBack(OnDialogCallBack callBack) {
        this.callBack = callBack;
        mCallBack = this.callBack;
    }


    @Override
    public void setArguments(Bundle args) {
        String from = args.getString(ARGS_FROM);
        //默认来自activity
        if (TextUtils.isEmpty(from)) {
            args.putString(ARGS_FROM, FROM_ACTIVITY);
        }
        super.setArguments(args);
    }

    public static DialogAlert newInstance(Bundle b) {
        DialogAlert fragment = new DialogAlert();
        fragment.setArguments(b);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_TITLE, R.style.dialogStyle);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        //重写onAttach拦截从非activity创建的dialogalert,非
        switch (getArguments().getString(ARGS_FROM)) {
            case FROM_ACTIVITY:
                break;
            case FROM_DIALOGFRAGMENT:
                //从dialogfragment创建的不用初始化callback
                mCallBack = this.callBack;
                break;
            default:
                break;
        }
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_tip_layout, null);
        parseArgs();

        tvMsg = (TextView) view.findViewById(R.id.dialog_msg);
        pbBar = (ProgressBar) view.findViewById(R.id.dialog_progress);
        ivIcon = (ImageView) view.findViewById(R.id.dialog_icon);

        tvMsg.setText(message);
        changeState(this.state);
        return view;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        changeState(this.state);
    }

    public void setMessage(String msg) {
        this.message = msg;
        this.tvMsg.setText(this.message);
    }

    private synchronized void changeState(int state) {
        switch (state) {
            case STATE_FAILED:
                ivIcon.setImageResource(R.drawable.ic_close);
                ivIcon.setVisibility(View.VISIBLE);
                pbBar.setVisibility(View.GONE);
                handler.sendEmptyMessageDelayed(1, 1000);
                break;
            case STATE_SUCCESS:
                ivIcon.setImageResource(R.drawable.ic_success);
                ivIcon.setVisibility(View.VISIBLE);
                pbBar.setVisibility(View.GONE);
                handler.sendEmptyMessageDelayed(1, 1000);
                break;
            case STATE_LOADING:
                ivIcon.setVisibility(View.GONE);
                pbBar.setVisibility(View.VISIBLE);
                break;
            case STATE_DEFAULT:
            default:
                ivIcon.setImageResource(R.drawable.ic_warning);
                ivIcon.setVisibility(View.VISIBLE);
                pbBar.setVisibility(View.GONE);
                handler.sendEmptyMessageDelayed(1, 1000);
                break;
        }
    }

    private void parseArgs() {
        title = getArguments().getString(ARGS_TITLE);
        message = getArguments().getString(ARGS_MESSAGE);
        cancel = getArguments().getString(ARGS_CANCEL);
        sure = getArguments().getString(ARGS_SURE);
        icon = getArguments().getInt(ARGS_ICON);
        extra = getArguments().getString(ARGS_BTN_EXTRA);
        state = getArguments().getInt(ARGS_STATE);
    }

//    @Override
//    public Dialog onCreateDialog(Bundle savedInstanceState) {
//        parseArgs();
//        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//        builder.setCancelable(true);
//        builder.setTitle(title);
//        builder.setMessage(message);
//        builder.setPositiveButton(sure,this);
//        builder.setNegativeButton(cancel,this);
//        builder.setNeutralButton(extra,this);
//        builder.setIcon(icon);
//        AlertDialog dia = builder.create();
//        dia.setCanceledOnTouchOutside(false);
//        return dia;
//    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        if (which == Dialog.BUTTON_POSITIVE) {
            mCallBack.onSure(this, which);
        } else if (which == Dialog.BUTTON_NEUTRAL) {
            mCallBack.onSure(this, which);
        } else {
            mCallBack.onCancel(this);
        }
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    dismiss();
                    break;
            }
        }
    };
}
