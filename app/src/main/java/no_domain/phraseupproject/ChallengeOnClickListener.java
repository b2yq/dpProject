package no_domain.phraseupproject;

import android.content.Intent;
import android.view.View;

class ChallengeOnClickListener implements View.OnClickListener
{
    ChallengeActivity activity;
    private Intent intent;
    private boolean success;
    private String successWord;

    public ChallengeOnClickListener(ChallengeActivity activity, boolean success, String successWord)
    {
        this.activity = activity;
        this.success = success;
        this.successWord = successWord;
        intent = new Intent(activity, ResultActivity.class);
    }

    @Override
    public void onClick(View v)
    {
        intent.putExtra("SUCCESSWORD", successWord);

        if(success)
        {
            intent.putExtra("STATUS", "SUCCESS");
        }
        else
        {
            intent.putExtra("STATUS", "FAIL");
        }

        //przekierowanie do ResultActivity
        activity.startActivityForResult(intent, 0);

    }
}
