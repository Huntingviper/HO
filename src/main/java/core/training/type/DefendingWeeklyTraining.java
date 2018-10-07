package core.training.type;

import java.util.List;

import core.constants.TrainingType;
import core.constants.player.PlayerSkill;
import core.model.StaffMember;
import core.model.UserParameter;
import core.model.player.ISpielerPosition;
import core.model.player.Spieler;
import core.training.WeeklyTrainingType;

public final class DefendingWeeklyTraining extends WeeklyTrainingType {
	protected static DefendingWeeklyTraining m_ciInstance = null;
	private DefendingWeeklyTraining()
	{
		_Name = "Defending";
		_TrainingType = TrainingType.DEFENDING;
		_PrimaryTrainingSkill = PlayerSkill.DEFENDING;
		_PrimaryTrainingSkillPositions = new int[]{ 
				ISpielerPosition.leftBack, ISpielerPosition.rightBack, ISpielerPosition.leftCentralDefender,
				ISpielerPosition.middleCentralDefender, ISpielerPosition.rightCentralDefender};
		_PrimaryTrainingSkillOsmosisTrainingPositions = new int[]{
				ISpielerPosition.keeper, ISpielerPosition.rightWinger, ISpielerPosition.leftWinger, 
				ISpielerPosition.leftInnerMidfield, ISpielerPosition.centralInnerMidfield, 
				ISpielerPosition.rightInnerMidfield, ISpielerPosition.leftForward, 
				ISpielerPosition.centralForward, ISpielerPosition.rightForward};
		_PrimaryTrainingBaseLength = (float) 5.4824; // old was 3.6
		_PrimaryTrainingSkillBaseLength = _PrimaryTrainingBaseLength + UserParameter.instance().TRAINING_OFFSET_DEFENDING; // 100%
		//_PrimaryTrainingSkillSecondaryLengthRate = (float) 2; // 50% there are no secondary training positions
	}
	public static DefendingWeeklyTraining instance() {
        if (m_ciInstance == null) {
        	m_ciInstance = new DefendingWeeklyTraining();
        }
        return m_ciInstance;
    }
	@Override
	 public double getTrainingLength(Spieler player, int assistants, int trainerLevel, int intensity, int stamina, List<StaffMember> staff) 
	 {
		 return calcTraining(getPrimaryTrainingSkillBaseLength(), player.getAlter(), assistants, trainerLevel, 
				 intensity, stamina, player.getVerteidigung(), staff);
	 }
	 @Override
	 public double getSecondaryTrainingLength(Spieler player, int assistants, int trainerLevel, int intensity, int stamina, List<StaffMember> staff)
	 {
		 return (double) -1;
	 }	 
}
