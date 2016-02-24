import com.atlassian.jira.issue.CustomFieldManager;
import com.atlassian.jira.issue.fields.CustomField;
import com.atlassian.jira.issue.util.DefaultIssueChangeHolder;
import com.atlassian.jira.ComponentManager;
import com.atlassian.jira.issue.customfields.option.Options;
import com.atlassian.jira.issue.customfields.option.Option;
import com.atlassian.jira.issue.ModifiedValue;
import com.atlassian.jira.component.ComponentAccessor;

// Custom field ID's
int sourceCfID = 10101;
int targetCfID = 10102;

// Option ID's of target custom field
int optionFirst = 99998;
int optionSecond = 99999;

CustomFieldManager customFieldManager = ComponentManager.getInstance().getCustomFieldManager();

String sourceCfValue = customFieldManager.getCustomFieldObject(sourceCfID).getValue(issue).toString();

CustomField targetCf = customFieldManager.getCustomFieldObject(targetCfID);

// If value of source custom field is XXX, then select first option, if NOT select second option
// This can be replaced by switch statement if you need to check more options!!!!
int targetCfOption = (sourceCfValue == 'XXX') ? optionFirst : optionSecond;

Options targetCfOptions = ComponentAccessor.getOptionsManager().getOptions(targetCf.getRelevantConfig(issue));

Option ChoosenOption = targetCfOptions.getOptionById(targetCfOption);

targetCf.updateValue(null, issue, new ModifiedValue(issue.getCustomFieldValue(targetCf), ChoosenOption), new DefaultIssueChangeHolder());